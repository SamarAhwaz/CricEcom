package com.example.cricEcom.ServiceImplementation;

import java.math.BigDecimal;

import com.example.cricEcom.Repo.UserRepo;
import com.example.cricEcom.entities.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cricEcom.Repo.CartRepo;
import com.example.cricEcom.Repo.PaymentRepo;
import com.example.cricEcom.RequestDto.PaymentConfirmRequestDto;
import com.example.cricEcom.RequestDto.PaymentInitiatedRequestDto;
import com.example.cricEcom.ResponsDto.OrderResponseDto;
import com.example.cricEcom.ResponsDto.PaymentInitiatedResponseDto;
import com.example.cricEcom.ResponsDto.PaymentResponseDto;
import com.example.cricEcom.Service.OrderService;
import com.example.cricEcom.Service.PaymentService;
import com.example.cricEcom.Util.RazorPayUtil;
import com.example.cricEcom.entities.Payment;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImplementation implements PaymentService {

    private final PaymentRepo paymentRepo;
    private final CartRepo cartRepo;
    private final UserRepo userRepo;
    private final OrderService orderService;

    @Value("${razorpay.key}")
    private String key;

    @Value("${razorpay.secret}")
    private String secret;


    // ---------------- INITIATE PAYMENT ------------------
    @Override
    public PaymentInitiatedResponseDto initiatePayment(PaymentInitiatedRequestDto req) {

        try {
            User user = userRepo.findById(req.userId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            // Convert amount to paise
            int amountInPaise = req.amount().multiply(BigDecimal.valueOf(100)).intValue();

            // Create Razorpay order
            RazorpayClient client = new RazorpayClient(key, secret);

            JSONObject options = new JSONObject();
            options.put("amount", amountInPaise);
            options.put("currency", "INR");
            options.put("receipt", "rcpt_" + System.currentTimeMillis());

            Order order = client.orders.create(options);

            // Save as PENDING
            Payment p = new Payment();
            p.setUser(user);
            p.setAmount(req.amount());
            p.setStatus(Payment.PaymentStatus.PENDING);
            p.setGatewayOrderId(order.get("id"));

            Payment saved = paymentRepo.save(p);

            return new PaymentInitiatedResponseDto(saved.getId(), order.get("id"), amountInPaise);

        } catch (Exception e) {
            throw new RuntimeException("Error creating Razorpay order: " + e.getMessage());
        }
    }


    // ---------------- CONFIRM PAYMENT ------------------
    @Override
    public String confirmPayment(PaymentConfirmRequestDto req) {

        Payment payment = paymentRepo.findById(req.paymentId())
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        boolean valid = RazorPayUtil.verifySignature(
                req.razorpayOrderId(),
                req.razorpayPaymentId(),
                req.razorpaySignature(),
                secret
        );

        if (!valid) {
            throw new RuntimeException("Invalid payment signature");
        }

        // Mark success
        payment.setStatus(Payment.PaymentStatus.SUCCESS);
        payment.setGatewayPaymentId(req.razorpayPaymentId());
//        payment.setSignature(req.razorpaySignature());

        paymentRepo.save(payment);

        return "Payment Successful";
    }


	@Override
	public PaymentResponseDto getPayment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
