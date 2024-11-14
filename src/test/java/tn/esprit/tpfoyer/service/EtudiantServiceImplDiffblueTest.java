package tn.esprit.tpfoyer.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.repository.EtudiantRepository;

@ContextConfiguration(classes = {EtudiantServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EtudiantServiceImplDiffblueTest {
    @MockBean
    private EtudiantRepository etudiantRepository;

    @Autowired
    private EtudiantServiceImpl etudiantServiceImpl;

    /**
     * Test {@link EtudiantServiceImpl#retrieveAllEtudiants()}.
     * <p>
     * Method under test: {@link EtudiantServiceImpl#retrieveAllEtudiants()}
     */
    @Test
    @DisplayName("Test retrieveAllEtudiants()")
    void testRetrieveAllEtudiants() {
        // Arrange
        when(etudiantRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<Etudiant> actualRetrieveAllEtudiantsResult = etudiantServiceImpl.retrieveAllEtudiants();

        // Assert
        verify(etudiantRepository).findAll();
        assertTrue(actualRetrieveAllEtudiantsResult.isEmpty());
    }
    /**/

    /**
     * Test {@link EtudiantServiceImpl#retrieveEtudiant(Long)}.
     * <ul>
     *   <li>Given {@link Etudiant#Etudiant()} CinEtudiant is one.</li>
     *   <li>Then return {@link Etudiant#Etudiant()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link EtudiantServiceImpl#retrieveEtudiant(Long)}
     *//**/
    @Test
    @DisplayName("Test retrieveEtudiant(Long); given Etudiant() CinEtudiant is one; then return Etudiant()")
    void testRetrieveEtudiant_givenEtudiantCinEtudiantIsOne_thenReturnEtudiant() {
        // Arrange
        Etudiant etudiant = new Etudiant();
        etudiant.setCinEtudiant(1L);
        etudiant.setDateNaissance(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        etudiant.setIdEtudiant(1L);
        etudiant.setNomEtudiant("Nom Etudiant");
        etudiant.setPrenomEtudiant("Prenom Etudiant");
        etudiant.setReservations(new HashSet<>());
        Optional<Etudiant> ofResult = Optional.of(etudiant);
        when(etudiantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Etudiant actualRetrieveEtudiantResult = etudiantServiceImpl.retrieveEtudiant(1L);

        // Assert
        verify(etudiantRepository).findById(eq(1L));
        assertSame(etudiant, actualRetrieveEtudiantResult);
    }

    /**
     * Test {@link EtudiantServiceImpl#addEtudiant(Etudiant)}.
     * <p>
     * Method under test: {@link EtudiantServiceImpl#addEtudiant(Etudiant)}
     */
    @Test
    @DisplayName("Test addEtudiant(Etudiant)")
    void testAddEtudiant() {
        // Arrange
        Etudiant etudiant = new Etudiant();
        etudiant.setCinEtudiant(1L);
        etudiant.setDateNaissance(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        etudiant.setIdEtudiant(1L);
        etudiant.setNomEtudiant("Nom Etudiant");
        etudiant.setPrenomEtudiant("Prenom Etudiant");
        etudiant.setReservations(new HashSet<>());
        when(etudiantRepository.save(Mockito.<Etudiant>any())).thenReturn(etudiant);

        Etudiant c = new Etudiant();
        c.setCinEtudiant(1L);
        c.setDateNaissance(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        c.setIdEtudiant(1L);
        c.setNomEtudiant("Nom Etudiant");
        c.setPrenomEtudiant("Prenom Etudiant");
        c.setReservations(new HashSet<>());

        // Act
        Etudiant actualAddEtudiantResult = etudiantServiceImpl.addEtudiant(c);

        // Assert
        verify(etudiantRepository).save(isA(Etudiant.class));
        assertSame(etudiant, actualAddEtudiantResult);
    }

    /**
     * Test {@link EtudiantServiceImpl#modifyEtudiant(Etudiant)}.
     * <p>
     * Method under test: {@link EtudiantServiceImpl#modifyEtudiant(Etudiant)}
     */
    @Test
    @DisplayName("Test modifyEtudiant(Etudiant)")
    void testModifyEtudiant() {
        // Arrange
        Etudiant etudiant = new Etudiant();
        etudiant.setCinEtudiant(1L);
        etudiant.setDateNaissance(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        etudiant.setIdEtudiant(1L);
        etudiant.setNomEtudiant("Nom Etudiant");
        etudiant.setPrenomEtudiant("Prenom Etudiant");
        etudiant.setReservations(new HashSet<>());
        when(etudiantRepository.save(Mockito.<Etudiant>any())).thenReturn(etudiant);

        Etudiant c = new Etudiant();
        c.setCinEtudiant(1L);
        c.setDateNaissance(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        c.setIdEtudiant(1L);
        c.setNomEtudiant("Nom Etudiant");
        c.setPrenomEtudiant("Prenom Etudiant");
        c.setReservations(new HashSet<>());

        // Act
        Etudiant actualModifyEtudiantResult = etudiantServiceImpl.modifyEtudiant(c);

        // Assert
        verify(etudiantRepository).save(isA(Etudiant.class));
        assertSame(etudiant, actualModifyEtudiantResult);
    }

    /**
     * Test {@link EtudiantServiceImpl#removeEtudiant(Long)}.
     * <p>
     * Method under test: {@link EtudiantServiceImpl#removeEtudiant(Long)}
     */
    @Test
    @DisplayName("Test removeEtudiant(Long)")
    void testRemoveEtudiant() {
        // Arrange
        doNothing().when(etudiantRepository).deleteById(Mockito.<Long>any());

        // Act
        etudiantServiceImpl.removeEtudiant(1L);

        // Assert that nothing has changed
        verify(etudiantRepository).deleteById(eq(1L));
    }

    /**
     * Test {@link EtudiantServiceImpl#recupererEtudiantParCin(long)}.
     * <p>
     * Method under test: {@link EtudiantServiceImpl#recupererEtudiantParCin(long)}
     */
    @Test
    @DisplayName("Test recupererEtudiantParCin(long)")
    void testRecupererEtudiantParCin() {
        // Arrange
        Etudiant etudiant = new Etudiant();
        etudiant.setCinEtudiant(1L);
        etudiant.setDateNaissance(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        etudiant.setIdEtudiant(1L);
        etudiant.setNomEtudiant("Nom Etudiant");
        etudiant.setPrenomEtudiant("Prenom Etudiant");
        etudiant.setReservations(new HashSet<>());
        when(etudiantRepository.findEtudiantByCinEtudiant(anyLong())).thenReturn(etudiant);

        // Act
        Etudiant actualRecupererEtudiantParCinResult = etudiantServiceImpl.recupererEtudiantParCin(1L);

        // Assert
        verify(etudiantRepository).findEtudiantByCinEtudiant(eq(1L));
        assertSame(etudiant, actualRecupererEtudiantParCinResult);
    }
}
