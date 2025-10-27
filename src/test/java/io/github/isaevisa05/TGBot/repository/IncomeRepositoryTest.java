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
        for (int i = 0; i < 10; i++, incomeRepository.save(new Income())) ;
        final List<Income> found = incomeRepository.findAll();
        assertEquals(10, found.size());
    }

}