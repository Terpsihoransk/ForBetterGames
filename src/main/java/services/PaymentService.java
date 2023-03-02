package services;

import models.dto.PaymentDto;

import java.util.List;

public interface PaymentService {

    List<PaymentDto> getAll();

    PaymentDto getById(Long id);

    void create(PaymentDto paymentDto);

    void update(PaymentDto paymentDto);

    void delete(Long id);

}
