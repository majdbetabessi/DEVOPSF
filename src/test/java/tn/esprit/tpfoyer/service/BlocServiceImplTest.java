package tn.esprit.tpfoyer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.BlocRepository;

@ContextConfiguration(classes = {BlocServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class BlocServiceImplTest {
    @MockBean
    private BlocRepository blocRepository;

    @Autowired
    private BlocServiceImpl blocServiceImpl;

    /**
     * Method under test: {@link BlocServiceImpl#retrieveAllBlocs()}
     */
    @Test
    void testRetrieveAllBlocs() {
        // Arrange
        ArrayList<Bloc> blocList = new ArrayList<>();
        when(blocRepository.findAll()).thenReturn(blocList);

        // Act
        List<Bloc> actualRetrieveAllBlocsResult = blocServiceImpl.retrieveAllBlocs();

        // Assert
        verify(blocRepository).findAll();
        assertTrue(actualRetrieveAllBlocsResult.isEmpty());
        assertSame(blocList, actualRetrieveAllBlocsResult);
    }

    /**
     * Method under test: {@link BlocServiceImpl#retrieveAllBlocs()}
     */
    @Test
    void testRetrieveAllBlocs2() {
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

        Bloc bloc = new Bloc();
        bloc.setCapaciteBloc(1L);
        bloc.setChambres(new HashSet<>());
        bloc.setFoyer(foyer2);
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Nom Bloc");

        ArrayList<Bloc> blocList = new ArrayList<>();
        blocList.add(bloc);
        when(blocRepository.findAll()).thenReturn(blocList);

        // Act
        List<Bloc> actualRetrieveAllBlocsResult = blocServiceImpl.retrieveAllBlocs();

        // Assert
        verify(blocRepository).findAll();
        assertEquals(1, actualRetrieveAllBlocsResult.size());
        assertSame(bloc, actualRetrieveAllBlocsResult.get(0));
    }

    /**
     * Method under test: {@link BlocServiceImpl#retrieveBlocsSelonCapacite(long)}
     */
    @Test
    void testRetrieveBlocsSelonCapacite() {
        // Arrange
        when(blocRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<Bloc> actualRetrieveBlocsSelonCapaciteResult = blocServiceImpl.retrieveBlocsSelonCapacite(1L);

        // Assert
        verify(blocRepository).findAll();
        assertTrue(actualRetrieveBlocsSelonCapaciteResult.isEmpty());
    }

    /**
     * Method under test: {@link BlocServiceImpl#retrieveBlocsSelonCapacite(long)}
     */
    @Test
    void testRetrieveBlocsSelonCapacite2() {
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

        Bloc bloc = new Bloc();
        bloc.setCapaciteBloc(1L);
        bloc.setChambres(new HashSet<>());
        bloc.setFoyer(foyer2);
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Nom Bloc");

        ArrayList<Bloc> blocList = new ArrayList<>();
        blocList.add(bloc);
        when(blocRepository.findAll()).thenReturn(blocList);

        // Act
        List<Bloc> actualRetrieveBlocsSelonCapaciteResult = blocServiceImpl.retrieveBlocsSelonCapacite(1L);

        // Assert
        verify(blocRepository).findAll();
        assertEquals(1, actualRetrieveBlocsSelonCapaciteResult.size());
        assertSame(bloc, actualRetrieveBlocsSelonCapaciteResult.get(0));
    }

    /**
     * Method under test: {@link BlocServiceImpl#retrieveBlocsSelonCapacite(long)}
     */
    @Test
    void testRetrieveBlocsSelonCapacite3() {
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

        Bloc bloc = new Bloc();
        bloc.setCapaciteBloc(1L);
        bloc.setChambres(new HashSet<>());
        bloc.setFoyer(foyer2);
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Nom Bloc");

        Foyer foyer3 = new Foyer();
        foyer3.setBlocs(new HashSet<>());
        foyer3.setCapaciteFoyer(0L);
        foyer3.setIdFoyer(2L);
        foyer3.setNomFoyer("42");
        foyer3.setUniversite(new Universite());

        Universite universite2 = new Universite();
        universite2.setAdresse("42");
        universite2.setFoyer(foyer3);
        universite2.setIdUniversite(2L);
        universite2.setNomUniversite("42");

        Foyer foyer4 = new Foyer();
        foyer4.setBlocs(new HashSet<>());
        foyer4.setCapaciteFoyer(0L);
        foyer4.setIdFoyer(2L);
        foyer4.setNomFoyer("42");
        foyer4.setUniversite(universite2);

        Bloc bloc2 = new Bloc();
        bloc2.setCapaciteBloc(0L);
        bloc2.setChambres(new HashSet<>());
        bloc2.setFoyer(foyer4);
        bloc2.setIdBloc(2L);
        bloc2.setNomBloc("42");

        ArrayList<Bloc> blocList = new ArrayList<>();
        blocList.add(bloc2);
        blocList.add(bloc);
        when(blocRepository.findAll()).thenReturn(blocList);

        // Act
        List<Bloc> actualRetrieveBlocsSelonCapaciteResult = blocServiceImpl.retrieveBlocsSelonCapacite(1L);

        // Assert
        verify(blocRepository).findAll();
        assertEquals(1, actualRetrieveBlocsSelonCapaciteResult.size());
        assertSame(bloc, actualRetrieveBlocsSelonCapaciteResult.get(0));
    }

    /**
     * Method under test: {@link BlocServiceImpl#retrieveBloc(Long)}
     */
    @Test
    void testRetrieveBloc() {
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

        Bloc bloc = new Bloc();
        bloc.setCapaciteBloc(1L);
        bloc.setChambres(new HashSet<>());
        bloc.setFoyer(foyer2);
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Nom Bloc");
        Optional<Bloc> ofResult = Optional.of(bloc);
        when(blocRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Bloc actualRetrieveBlocResult = blocServiceImpl.retrieveBloc(1L);

        // Assert
        verify(blocRepository).findById(eq(1L));
        assertSame(bloc, actualRetrieveBlocResult);
    }

    /**
     * Method under test: {@link BlocServiceImpl#addBloc(Bloc)}
     */
    @Test
    void testAddBloc() {
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

        Bloc bloc = new Bloc();
        bloc.setCapaciteBloc(1L);
        bloc.setChambres(new HashSet<>());
        bloc.setFoyer(foyer2);
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Nom Bloc");
        when(blocRepository.save(Mockito.<Bloc>any())).thenReturn(bloc);

        Foyer foyer3 = new Foyer();
        foyer3.setBlocs(new HashSet<>());
        foyer3.setCapaciteFoyer(1L);
        foyer3.setIdFoyer(1L);
        foyer3.setNomFoyer("Nom Foyer");
        foyer3.setUniversite(new Universite());

        Universite universite3 = new Universite();
        universite3.setAdresse("Adresse");
        universite3.setFoyer(foyer3);
        universite3.setIdUniversite(1L);
        universite3.setNomUniversite("Nom Universite");

        Foyer foyer4 = new Foyer();
        foyer4.setBlocs(new HashSet<>());
        foyer4.setCapaciteFoyer(1L);
        foyer4.setIdFoyer(1L);
        foyer4.setNomFoyer("Nom Foyer");
        foyer4.setUniversite(universite3);

        Bloc c = new Bloc();
        c.setCapaciteBloc(1L);
        c.setChambres(new HashSet<>());
        c.setFoyer(foyer4);
        c.setIdBloc(1L);
        c.setNomBloc("Nom Bloc");

        // Act
        Bloc actualAddBlocResult = blocServiceImpl.addBloc(c);

        // Assert
        verify(blocRepository).save(isA(Bloc.class));
        assertSame(bloc, actualAddBlocResult);
    }

    /**
     * Method under test: {@link BlocServiceImpl#modifyBloc(Bloc)}
     */
    @Test
    void testModifyBloc() {
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

        Bloc bloc = new Bloc();
        bloc.setCapaciteBloc(1L);
        bloc.setChambres(new HashSet<>());
        bloc.setFoyer(foyer2);
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Nom Bloc");
        when(blocRepository.save(Mockito.<Bloc>any())).thenReturn(bloc);

        Foyer foyer3 = new Foyer();
        foyer3.setBlocs(new HashSet<>());
        foyer3.setCapaciteFoyer(1L);
        foyer3.setIdFoyer(1L);
        foyer3.setNomFoyer("Nom Foyer");
        foyer3.setUniversite(new Universite());

        Universite universite3 = new Universite();
        universite3.setAdresse("Adresse");
        universite3.setFoyer(foyer3);
        universite3.setIdUniversite(1L);
        universite3.setNomUniversite("Nom Universite");

        Foyer foyer4 = new Foyer();
        foyer4.setBlocs(new HashSet<>());
        foyer4.setCapaciteFoyer(1L);
        foyer4.setIdFoyer(1L);
        foyer4.setNomFoyer("Nom Foyer");
        foyer4.setUniversite(universite3);

        Bloc bloc2 = new Bloc();
        bloc2.setCapaciteBloc(1L);
        bloc2.setChambres(new HashSet<>());
        bloc2.setFoyer(foyer4);
        bloc2.setIdBloc(1L);
        bloc2.setNomBloc("Nom Bloc");

        // Act
        Bloc actualModifyBlocResult = blocServiceImpl.modifyBloc(bloc2);

        // Assert
        verify(blocRepository).save(isA(Bloc.class));
        assertSame(bloc, actualModifyBlocResult);
    }

    /**
     * Method under test: {@link BlocServiceImpl#removeBloc(Long)}
     */
    @Test
    void testRemoveBloc() {
        // Arrange
        doNothing().when(blocRepository).deleteById(Mockito.<Long>any());

        // Act
        blocServiceImpl.removeBloc(1L);

        // Assert that nothing has changed
        verify(blocRepository).deleteById(eq(1L));
    }

    /**
     * Method under test: {@link BlocServiceImpl#trouverBlocsSansFoyer()}
     */
    @Test
    void testTrouverBlocsSansFoyer() {
        // Arrange
        ArrayList<Bloc> blocList = new ArrayList<>();
        when(blocRepository.findAllByFoyerIsNull()).thenReturn(blocList);

        // Act
        List<Bloc> actualTrouverBlocsSansFoyerResult = blocServiceImpl.trouverBlocsSansFoyer();

        // Assert
        verify(blocRepository).findAllByFoyerIsNull();
        assertTrue(actualTrouverBlocsSansFoyerResult.isEmpty());
        assertSame(blocList, actualTrouverBlocsSansFoyerResult);
    }

    /**
     * Method under test:
     * {@link BlocServiceImpl#trouverBlocsParNomEtCap(String, long)}
     */
    @Test
    void testTrouverBlocsParNomEtCap() {
        // Arrange
        ArrayList<Bloc> blocList = new ArrayList<>();
        when(blocRepository.findAllByNomBlocAndCapaciteBloc(Mockito.<String>any(), anyLong())).thenReturn(blocList);

        // Act
        List<Bloc> actualTrouverBlocsParNomEtCapResult = blocServiceImpl.trouverBlocsParNomEtCap("Nb", 1L);

        // Assert
        verify(blocRepository).findAllByNomBlocAndCapaciteBloc(eq("Nb"), eq(1L));
        assertTrue(actualTrouverBlocsParNomEtCapResult.isEmpty());
        assertSame(blocList, actualTrouverBlocsParNomEtCapResult);
    }
}
