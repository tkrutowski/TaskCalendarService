package net.focik.taskcalendar.infrastructure.jpa;

import net.focik.taskcalendar.infrastructure.dto.EntryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

interface ITaskCalendarDtoRepository extends JpaRepository<EntryDto, Integer> {

    List<EntryDto> findAllByDateOrderByDate(LocalDate date);
}
