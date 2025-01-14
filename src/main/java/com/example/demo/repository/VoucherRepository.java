package com.example.demo.repository;

 import com.example.demo.model.Voucher;
 import com.example.demo.service.DefaultService;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {


}
