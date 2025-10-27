package io.github.isaevisa05.TGBot.repository;

import io.github.isaevisa05.TGBot.entity.Income;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class IncomeRepositoryTest {

    @Autowired
    private IncomeRepository incomeRepository;

    @Test
    public void testRepo() {
        for (int i = 0; i < 10; i++, incomeRepository.save(new Income())) ;
        final List<Income> found = incomeRepository.findAll();
        assertEquals(10, found.size());
    }

    @Test
    public void testDataScripts() {
        var income = incomeRepository.findById(12345L);
        System.out.println(income);

        if(income.isEmpty()) System.out.println(true);
        if(income.isEmpty()) System.out.println(true);
        if(income.isEmpty()) System.out.println(true);
        if(income.isEmpty()) System.out.println(true);
        if(income.isEmpty()) System.out.println(true);
        if(income.isEmpty()) System.out.println(true);
        if(income.isEmpty()) System.out.println(true);
        if(income.isEmpty()) System.out.println(true);

        //assertTrue(income.isPresent());
        //assertEquals(income.get().getIncome(), new BigDecimal("43500"));
    }


}