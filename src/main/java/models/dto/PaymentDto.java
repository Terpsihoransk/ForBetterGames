package models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {

    private Long id;

    private String number;

    private LocalDateTime date;

    private BigDecimal amount;

    private String purpose;

    private BigDecimal tax;

    private String comment;

    private boolean isDone;

    private TypeOfPayment typeOfPayment;

    private CompanyDto companyDto = new CompanyDto();

    private ContractorDto contractorDto = new ContractorDto();

    private Long contractId;

    private String contractNumber;

    private Long projectId;

    private String projectName;

    private Long paymentExpenditureId;

    private String paymentExpenditureName;

    private List<Document> documents = new ArrayList<>();

    private List<TaskDto> taskDtos = new ArrayList<>();

    public PaymentDto(Long id,
                      String number,
                      LocalDateTime date,
                      BigDecimal amount,
                      String purpose,
                      BigDecimal tax,
                      boolean isDone,
                      String comment,
                      TypeOfPayment typeOfPayment,
                      Long companyId,
                      Long contractorId,
                      Long contractId,
                      String contractNumber,
                      Long projectId,
                      String projectName,
                      Long paymentExpenditureId,
                      String paymentExpenditureName) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.amount = amount;
        this.purpose = purpose;
        this.tax = tax;
        this.isDone = isDone;
        this.comment = comment;
        this.typeOfPayment = typeOfPayment;
        this.companyDto.setId(companyId);
        this.contractorDto.setId(contractorId);
        this.contractId = contractId;
        this.contractNumber = contractNumber;
        this.projectId = projectId;
        this.projectName = projectName;
        this.paymentExpenditureId = paymentExpenditureId;
        this.paymentExpenditureName = paymentExpenditureName;
    }
}
