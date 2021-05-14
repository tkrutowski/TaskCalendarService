package net.focik.taskcalendar.infrastructure.jpa;

import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

interface ITaskCalendarDtoRepository extends JpaRepository<EntryDbDto, Integer> {

//    @Query(
//            value = "select id_wpisu, id_zadania, id_brygady, rodzaj_zadania, data, info\n" +
//                    "from Kalendarz_zadania",
//            nativeQuery = true)
    List<EntryDbDto> findAllByDateOrderByDate(LocalDate date);
    List<EntryDbDto> findAllByDateBetweenOrderByDate(LocalDate startDate, LocalDate endDate);

}
