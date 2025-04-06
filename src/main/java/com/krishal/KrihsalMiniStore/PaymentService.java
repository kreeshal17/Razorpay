package com.krishal.KrihsalMiniStore;


import com.krishal.KrihsalMiniStore.Model.Payment;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    @Autowired
    PaymentRepository repo;


    @Value("${razorpay.key_id}")
    private String key_id;


    @Value("${razorpay.key_secret}")
    private String key_secret;


    public String createPayment(int amount,String currency,String receipt) throws RazorpayException {
        RazorpayClient client=new RazorpayClient(key_id,key_secret);


        JSONObject orderreq= new JSONObject();
        orderreq.put("amount",amount*100);
        orderreq.put("currency",currency);
        orderreq.put("receipt",receipt);

        Order order =client.orders.create(orderreq);
        return  order.toString();
    }

    public void savePaymentInfo(String paymentId, String name, String orderId, String signature, String paymentID, int amount, String currency, String status)
    {
        Payment info= new Payment();
        info.setName(name);
        info.setCurrency(currency);
        info.setRazorpayOrderId(orderId);
        info.setRazorpayPaymentId(paymentId);
        info.setRazorpaySignature(signature);
        info.setAmount(amount);
   info.setStatus("paid");
   repo.save(info);

    }





}
