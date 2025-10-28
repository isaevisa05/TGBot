package io.github.isaevisa05.TGBot.repository;

import io.github.isaevisa05.TGBot.entity.Income;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DataJpaTest
public class IncomeRepositoryTest {

    @Autowired
    private IncomeRepository incomeRepository;

    @Test
    public void testRepo() {
        int startSize = incomeRepository.findAll().size();

        for (int i = 0; i < 10; i++, incomeRepository.save(new Income())) ;
        final List<Income> found = incomeRepository.findAll();
        assertEquals(startSize + 10, found.size());
    }

    @Test
    public void testDataScripts() {
        var income = incomeRepository.findAll();
        System.out.println(income.size());
        System.out.println(income.size());
        System.out.println(income.size());
        System.out.println(income.size());

        //assertTrue(income.isPresent());
        //assertEquals(income.get().getIncome(), new BigDecimal("43500"));
    }


}