package com.krishal.KrihsalMiniStore;

import com.krishal.KrihsalMiniStore.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
