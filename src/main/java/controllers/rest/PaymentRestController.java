package controllers.rest;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Payment Rest Controller")
@Tag(name = "Payment Rest Controller", description = "CRUD операции с объектами")
public class PaymentRestController {

    private final PaymentService paymentService;
    private final CheckEntityService checkEntityService;
    private final PaymentRepository repository;

    public PaymentRestController(PaymentService paymentService, CheckEntityService checkEntityService, PaymentRepository repository) {
        this.paymentService = paymentService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все параметры рассчитываемого объекта", notes = "Возвращает список PaymentDto",
            response = PaymentDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа PaymentDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<PaymentDto>> getAll() {
        return ResponseEntity.ok(paymentService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает параметр рассчитываемого объекта с выбранным id", notes = "Возвращает PaymentDto",
            response = PaymentDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение PaymentDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 402, message = "Нет доступа к данной операции")})
    public ResponseEntity<PaymentDto> getById(@ApiParam(name = "id", value = "Id нужного PaymentDto", required = true)
                                              @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "Payment");
        return ResponseEntity.ok(paymentService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание PaymentDto",
                    response = PaymentDto.class),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 402, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "PaymentDto", value = "Объект PaymentDto для создания",
            required = true) @RequestBody PaymentDto paymentDto) {
        paymentService.create(paymentDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление PaymentDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "PaymentDto", value = "Объект PaymentDto для обновления",
            required = true) @RequestBody PaymentDto paymentDto) {
        checkEntityService.checkExist(paymentDto.getId(), repository, "Payment");
        paymentService.update(paymentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Обновляет параметр рассчитываемого объекта c выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление PaymentDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id PaymentDto для удаления", required = true)
                                        @PathVariable Long id) {
        checkEntityService.checkExist(id, repository, "Payment");
        paymentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
