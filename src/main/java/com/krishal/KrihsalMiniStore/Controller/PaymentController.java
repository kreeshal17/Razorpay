package com.krishal.KrihsalMiniStore.Controller;


import com.krishal.KrihsalMiniStore.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")




public class PaymentController {
    @Autowired
    PaymentService service;
    @PostMapping
    public String  createPayment(@RequestParam  int amount ,@RequestParam  String currency,@RequestParam  String receipt) throws RazorpayException {


     return    service.createPayment(amount, currency, receipt);




    }
    @PostMapping("/payment-success")
    public ResponseEntity<String> savePaymentInfo(
            @RequestParam String paymentId,
            @RequestParam String name,
            @RequestParam String orderId,
            @RequestParam String signature,
            @RequestParam String paymentID,
            @RequestParam int amount,
            @RequestParam String currency,
            @RequestParam String status) {
        service.savePaymentInfo(paymentId,name,orderId,signature,paymentID,amount,currency,status);
        return  new ResponseEntity<>( "payment imformation saved ", HttpStatus.OK);


    }

}
