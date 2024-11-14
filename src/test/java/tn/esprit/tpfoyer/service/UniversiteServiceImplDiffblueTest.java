package tn.esprit.tpfoyer.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;

@ContextConfiguration(classes = {UniversiteServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UniversiteServiceImplDiffblueTest {
    @MockBean
    private UniversiteRepository universiteRepository;

    @Autowired
    private UniversiteServiceImpl universiteServiceImpl;

    /**
     * Test {@link UniversiteServiceImpl#retrieveAllUniversites()}.
     * <p>
     * Method under test: {@link UniversiteServiceImpl#retrieveAllUniversites()}
     */
    @Test
    @DisplayName("Test retrieveAllUniversites()")
    void testRetrieveAllUniversites() {
        // Arrange
        when(universiteRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<Universite> actualRetrieveAllUniversitesResult = universiteServiceImpl.retrieveAllUniversites();

        // Assert
        verify(universiteRepository).findAll();
        assertTrue(actualRetrieveAllUniversitesResult.isEmpty());
    }

    /**
     * Test {@link UniversiteServiceImpl#retrieveUniversite(Long)}.
     * <ul>
     *   <li>Given {@link Foyer#Foyer()} Blocs is {@link HashSet#HashSet()}.</li>
     *   <li>Then return {@link Universite#Universite()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UniversiteServiceImpl#retrieveUniversite(Long)}
     */
    @Test
    @DisplayName("Test retrieveUniversite(Long); given Foyer() Blocs is HashSet(); then return Universite()")
    void testRetrieveUniversite_givenFoyerBlocsIsHashSet_thenReturnUniversite() {
        // Arrange
        Foyer foyer = new Foyer();
        foyer.setBlocs(new HashSet<>());
        foyer.setCapaciteFoyer(1L);
        foyer.setIdFoyer(1L);
        foyer.setNomFoyer("Nom Foyer");
        foyer.setUniversite(new Universite());

        Universite universite = new Universite();
        universite.setAdresse("Adresse");
        universite.setFoyer(foyer);
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Nom Universite");

        Foyer foyer2 = new Foyer();
        foyer2.setBlocs(new HashSet<>());
        foyer2.setCapaciteFoyer(1L);
        foyer2.setIdFoyer(1L);
        foyer2.setNomFoyer("Nom Foyer");
        foyer2.setUniversite(universite);

        Universite universite2 = new Universite();
        universite2.setAdresse("Adresse");
        universite2.setFoyer(foyer2);
        universite2.setIdUniversite(1L);
        universite2.setNomUniversite("Nom Universite");
        Optional<Universite> ofResult = Optional.of(universite2);
        when(universiteRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Universite actualRetrieveUniversiteResult = universiteServiceImpl.retrieveUniversite(1L);

        // Assert
        verify(universiteRepository).findById(eq(1L));
        assertSame(universite2, actualRetrieveUniversiteResult);
    }

    /**
     * Test {@link UniversiteServiceImpl#addUniversite(Universite)}.
     * <p>
     * Method under test: {@link UniversiteServiceImpl#addUniversite(Universite)}
     */
    @Test
    @DisplayName("Test addUniversite(Universite)")
    void testAddUniversite() {
        // Arrange
        Universite universite = new Universite();
        universite.setAdresse("Adresse");
        universite.setFoyer(new Foyer());
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Nom Universite");

        Foyer foyer = new Foyer();
        foyer.setBlocs(new HashSet<>());
        foyer.setCapaciteFoyer(1L);
        foyer.setIdFoyer(1L);
        foyer.setNomFoyer("Nom Foyer");
        foyer.setUniversite(universite);

        Universite universite2 = new Universite();
        universite2.setAdresse("Adresse");
        universite2.setFoyer(foyer);
        universite2.setIdUniversite(1L);
        universite2.setNomUniversite("Nom Universite");

        Foyer foyer2 = new Foyer();
        foyer2.setBlocs(new HashSet<>());
        foyer2.setCapaciteFoyer(1L);
        foyer2.setIdFoyer(1L);
        foyer2.setNomFoyer("Nom Foyer");
        foyer2.setUniversite(universite2);

        Universite universite3 = new Universite();
        universite3.setAdresse("Adresse");
        universite3.setFoyer(foyer2);
        universite3.setIdUniversite(1L);
        universite3.setNomUniversite("Nom Universite");
        when(universiteRepository.save(Mockito.<Universite>any())).thenReturn(universite3);

        Foyer foyer3 = new Foyer();
        foyer3.setBlocs(new HashSet<>());
        foyer3.setCapaciteFoyer(1L);
        foyer3.setIdFoyer(1L);
        foyer3.setNomFoyer("Nom Foyer");
        foyer3.setUniversite(new Universite());

        Universite universite4 = new Universite();
        universite4.setAdresse("Adresse");
        universite4.setFoyer(foyer3);
        universite4.setIdUniversite(1L);
        universite4.setNomUniversite("Nom Universite");

        Foyer foyer4 = new Foyer();
        foyer4.setBlocs(new HashSet<>());
        foyer4.setCapaciteFoyer(1L);
        foyer4.setIdFoyer(1L);
        foyer4.setNomFoyer("Nom Foyer");
        foyer4.setUniversite(universite4);

        Universite u = new Universite();
        u.setAdresse("Adresse");
        u.setFoyer(foyer4);
        u.setIdUniversite(1L);
        u.setNomUniversite("Nom Universite");

        // Act
        Universite actualAddUniversiteResult = universiteServiceImpl.addUniversite(u);

        // Assert
        verify(universiteRepository).save(isA(Universite.class));
        assertSame(universite3, actualAddUniversiteResult);
    }

    /**
     * Test {@link UniversiteServiceImpl#modifyUniversite(Universite)}.
     * <p>
     * Method under test: {@link UniversiteServiceImpl#modifyUniversite(Universite)}
     */
    @Test
    @DisplayName("Test modifyUniversite(Universite)")
    void testModifyUniversite() {
        // Arrange
        Universite universite = new Universite();
        universite.setAdresse("Adresse");
        universite.setFoyer(new Foyer());
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Nom Universite");

        Foyer foyer = new Foyer();
        foyer.setBlocs(new HashSet<>());
        foyer.setCapaciteFoyer(1L);
        foyer.setIdFoyer(1L);
        foyer.setNomFoyer("Nom Foyer");
        foyer.setUniversite(universite);

        Universite universite2 = new Universite();
        universite2.setAdresse("Adresse");
        universite2.setFoyer(foyer);
        universite2.setIdUniversite(1L);
        universite2.setNomUniversite("Nom Universite");

        Foyer foyer2 = new Foyer();
        foyer2.setBlocs(new HashSet<>());
        foyer2.setCapaciteFoyer(1L);
        foyer2.setIdFoyer(1L);
        foyer2.setNomFoyer("Nom Foyer");
        foyer2.setUniversite(universite2);

        Universite universite3 = new Universite();
        universite3.setAdresse("Adresse");
        universite3.setFoyer(foyer2);
        universite3.setIdUniversite(1L);
        universite3.setNomUniversite("Nom Universite");
        when(universiteRepository.save(Mockito.<Universite>any())).thenReturn(universite3);

        Foyer foyer3 = new Foyer();
        foyer3.setBlocs(new HashSet<>());
        foyer3.setCapaciteFoyer(1L);
        foyer3.setIdFoyer(1L);
        foyer3.setNomFoyer("Nom Foyer");
        foyer3.setUniversite(new Universite());

        Universite universite4 = new Universite();
        universite4.setAdresse("Adresse");
        universite4.setFoyer(foyer3);
        universite4.setIdUniversite(1L);
        universite4.setNomUniversite("Nom Universite");

        Foyer foyer4 = new Foyer();
        foyer4.setBlocs(new HashSet<>());
        foyer4.setCapaciteFoyer(1L);
        foyer4.setIdFoyer(1L);
        foyer4.setNomFoyer("Nom Foyer");
        foyer4.setUniversite(universite4);

        Universite universite5 = new Universite();
        universite5.setAdresse("Adresse");
        universite5.setFoyer(foyer4);
        universite5.setIdUniversite(1L);
        universite5.setNomUniversite("Nom Universite");

        // Act
        Universite actualModifyUniversiteResult = universiteServiceImpl.modifyUniversite(universite5);

        // Assert
        verify(universiteRepository).save(isA(Universite.class));
        assertSame(universite3, actualModifyUniversiteResult);
    }

    /**
     * Test {@link UniversiteServiceImpl#removeUniversite(Long)}.
     * <p>
     * Method under test: {@link UniversiteServiceImpl#removeUniversite(Long)}
     */
    @Test
    @DisplayName("Test removeUniversite(Long)")
    void testRemoveUniversite() {
        // Arrange
        doNothing().when(universiteRepository).deleteById(Mockito.<Long>any());

        // Act
        universiteServiceImpl.removeUniversite(1L);

        // Assert that nothing has changed
        verify(universiteRepository).deleteById(eq(1L));
    }
}
