package io.github.isaevisa05.TGBot.repository;

import io.github.isaevisa05.TGBot.entity.ActiveChat;
import io.github.isaevisa05.TGBot.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
}
