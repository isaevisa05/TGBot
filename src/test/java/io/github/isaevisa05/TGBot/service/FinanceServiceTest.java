package io.github.isaevisa05.TGBot.service;

import io.github.isaevisa05.TGBot.repository.IncomeRepository;
import io.github.isaevisa05.TGBot.repository.SpendRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FinanceServiceTest {

    @InjectMocks
    private FinanceService financeService;

    @Mock
    private SpendRepository spendRepository;

    @Mock
    private IncomeRepository incomeRepository;

    private long startTime;


    @BeforeEach
    public void beforeAll() {
        MockitoAnnotations.openMocks(this);
        startTime = System.currentTimeMillis();
    }

    @AfterEach
    public void afterAll() {
        long end = System.currentTimeMillis() - startTime;
        System.out.println("Тест выполнялся " + end + "мс");
    }

    @DisplayName("ADD_INCOME_test")
    @Test
    public void addFinanceOperationAddIncomeTest() {
        String price = "150";
        String message = financeService.addFinanceOperation("/addincome", price, 500L);
        Assertions.assertEquals("Доход в размере " + price + " был успешно добавлен", message);
    }

    @DisplayName("non_ADD_INCOME_test")
    @Test
    public void addFinanceOperationElseBranchTest() {
        String price = "200";
        String message = financeService.addFinanceOperation("/nan", price, 250L);
        Assertions.assertEquals("Расход в размере " + price + " был успешно добавлен", message);
    }
}