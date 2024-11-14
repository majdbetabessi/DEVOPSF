package tn.esprit.tpfoyer.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;

@ContextConfiguration(classes = {ReservationServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ReservationServiceImplTest {
    @MockBean
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationServiceImpl reservationServiceImpl;

    /**
     * Method under test: {@link ReservationServiceImpl#retrieveAllReservations()}
     */
    @Test
    void testRetrieveAllReservations() {
        // Arrange
        ArrayList<Reservation> reservationList = new ArrayList<>();
        when(reservationRepository.findAll()).thenReturn(reservationList);

        // Act
        List<Reservation> actualRetrieveAllReservationsResult = reservationServiceImpl.retrieveAllReservations();

        // Assert
        verify(reservationRepository).findAll();
        assertTrue(actualRetrieveAllReservationsResult.isEmpty());
        assertSame(reservationList, actualRetrieveAllReservationsResult);
    }

    /**
     * Method under test: {@link ReservationServiceImpl#retrieveReservation(String)}
     */
    @Test
    void testRetrieveReservation() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation
                .setAnneeUniversitaire(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        reservation.setEstValide(true);
        reservation.setEtudiants(new HashSet<>());
        reservation.setIdReservation("Id Reservation");
        Optional<Reservation> ofResult = Optional.of(reservation);
        when(reservationRepository.findById(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        Reservation actualRetrieveReservationResult = reservationServiceImpl.retrieveReservation("42");

        // Assert
        verify(reservationRepository).findById(eq("42"));
        assertSame(reservation, actualRetrieveReservationResult);
    }

    /**
     * Method under test: {@link ReservationServiceImpl#addReservation(Reservation)}
     */
    @Test
    void testAddReservation() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation
                .setAnneeUniversitaire(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        reservation.setEstValide(true);
        reservation.setEtudiants(new HashSet<>());
        reservation.setIdReservation("Id Reservation");
        when(reservationRepository.save(Mockito.<Reservation>any())).thenReturn(reservation);

        Reservation r = new Reservation();
        r.setAnneeUniversitaire(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        r.setEstValide(true);
        r.setEtudiants(new HashSet<>());
        r.setIdReservation("Id Reservation");

        // Act
        Reservation actualAddReservationResult = reservationServiceImpl.addReservation(r);

        // Assert
        verify(reservationRepository).save(isA(Reservation.class));
        assertSame(reservation, actualAddReservationResult);
    }

    /**
     * Method under test:
     * {@link ReservationServiceImpl#modifyReservation(Reservation)}
     */
    @Test
    void testModifyReservation() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation
                .setAnneeUniversitaire(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        reservation.setEstValide(true);
        reservation.setEtudiants(new HashSet<>());
        reservation.setIdReservation("Id Reservation");
        when(reservationRepository.save(Mockito.<Reservation>any())).thenReturn(reservation);

        Reservation reservation2 = new Reservation();
        reservation2
                .setAnneeUniversitaire(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        reservation2.setEstValide(true);
        reservation2.setEtudiants(new HashSet<>());
        reservation2.setIdReservation("Id Reservation");

        // Act
        Reservation actualModifyReservationResult = reservationServiceImpl.modifyReservation(reservation2);

        // Assert
        verify(reservationRepository).save(isA(Reservation.class));
        assertSame(reservation, actualModifyReservationResult);
    }

    /**
     * Method under test:
     * {@link ReservationServiceImpl#trouverResSelonDateEtStatus(Date, boolean)}
     */
    @Test
    void testTrouverResSelonDateEtStatus() {
        // Arrange
        ArrayList<Reservation> reservationList = new ArrayList<>();
        when(reservationRepository.findAllByAnneeUniversitaireBeforeAndEstValide(Mockito.<Date>any(), anyBoolean()))
                .thenReturn(reservationList);

        // Act
        List<Reservation> actualTrouverResSelonDateEtStatusResult = reservationServiceImpl.trouverResSelonDateEtStatus(
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), true);

        // Assert
        verify(reservationRepository).findAllByAnneeUniversitaireBeforeAndEstValide(isA(Date.class), eq(true));
        assertTrue(actualTrouverResSelonDateEtStatusResult.isEmpty());
        assertSame(reservationList, actualTrouverResSelonDateEtStatusResult);
    }

    /**
     * Method under test: {@link ReservationServiceImpl#removeReservation(String)}
     */
    @Test
    void testRemoveReservation() {
        // Arrange
        doNothing().when(reservationRepository).deleteById(Mockito.<String>any());

        // Act
        reservationServiceImpl.removeReservation("42");

        // Assert that nothing has changed
        verify(reservationRepository).deleteById(eq("42"));
    }
}
