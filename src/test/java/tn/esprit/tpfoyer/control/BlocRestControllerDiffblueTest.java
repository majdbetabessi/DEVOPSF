package tn.esprit.tpfoyer.control;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IBlocService;

@ContextConfiguration(classes = {BlocRestController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class BlocRestControllerDiffblueTest {
    @Autowired
    private BlocRestController blocRestController;

    @MockBean
    private IBlocService iBlocService;

    /**
     * Test {@link BlocRestController#addBloc(Bloc)}.
     * <p>
     * Method under test: {@link BlocRestController#addBloc(Bloc)}
     */
    @Test
    @DisplayName("Test addBloc(Bloc)")
    void testAddBloc() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/bloc/add-bloc", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        Bloc bloc = new Bloc();
        bloc.setCapaciteBloc(1L);
        HashSet<Chambre> chambres = new HashSet<>();
        bloc.setChambres(chambres);

        Foyer foyer = new Foyer();
        HashSet<Bloc> blocs = new HashSet<>();
        foyer.setBlocs(blocs);
        foyer.setCapaciteFoyer(1L);
        foyer.setIdFoyer(1L);
        foyer.setNomFoyer("Nom Foyer");

        Universite universite = new Universite();
        universite.setAdresse("Adresse");

        Foyer foyer2 = new Foyer();
        HashSet<Bloc> blocs2 = new HashSet<>();
        foyer2.setBlocs(blocs2);
        foyer2.setCapaciteFoyer(1L);
        foyer2.setIdFoyer(1L);
        foyer2.setNomFoyer("Nom Foyer");

        Universite universite2 = new Universite();
        universite2.setAdresse("Adresse");
        Foyer foyer3 = new Foyer();
        universite2.setFoyer(foyer3);
        universite2.setIdUniversite(1L);
        universite2.setNomUniversite("Nom Universite");
        foyer2.setUniversite(universite2);
        universite.setFoyer(foyer2);
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Nom Universite");
        foyer.setUniversite(universite);
        bloc.setFoyer(foyer);
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Nom Bloc");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(bloc));
        Object[] controllers = new Object[]{blocRestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link BlocRestController#retrieveBloc(Long)}.
     * <p>
     * Method under test: {@link BlocRestController#retrieveBloc(Long)}
     */
    @Test
    @DisplayName("Test retrieveBloc(Long)")
    void testRetrieveBloc() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bloc/retrieve-bloc/{bloc-id}",
                uriVariables);
        Object[] controllers = new Object[]{blocRestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link BlocRestController#removeBloc(Long)}.
     * <p>
     * Method under test: {@link BlocRestController#removeBloc(Long)}
     */
    @Test
    @DisplayName("Test removeBloc(Long)")
    void testRemoveBloc() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/bloc/remove-bloc/{bloc-id}",
                uriVariables);
        Object[] controllers = new Object[]{blocRestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link BlocRestController#recuperBlocsParNomEtCap(String, long)}.
     * <p>
     * Method under test:
     * {@link BlocRestController#recuperBlocsParNomEtCap(String, long)}
     */
    @Test
    @DisplayName("Test recuperBlocsParNomEtCap(String, long)")
    void testRecuperBlocsParNomEtCap() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{"Nb", 1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bloc/get-bloc-nb-c/{nb}/{c}",
                uriVariables);
        Object[] controllers = new Object[]{blocRestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link BlocRestController#modifyBloc(Bloc)}.
     * <p>
     * Method under test: {@link BlocRestController#modifyBloc(Bloc)}
     */
    @Test
    @DisplayName("Test modifyBloc(Bloc)")
    void testModifyBloc() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/bloc/modify-bloc", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        Bloc bloc = new Bloc();
        bloc.setCapaciteBloc(1L);
        HashSet<Chambre> chambres = new HashSet<>();
        bloc.setChambres(chambres);

        Foyer foyer = new Foyer();
        HashSet<Bloc> blocs = new HashSet<>();
        foyer.setBlocs(blocs);
        foyer.setCapaciteFoyer(1L);
        foyer.setIdFoyer(1L);
        foyer.setNomFoyer("Nom Foyer");

        Universite universite = new Universite();
        universite.setAdresse("Adresse");

        Foyer foyer2 = new Foyer();
        HashSet<Bloc> blocs2 = new HashSet<>();
        foyer2.setBlocs(blocs2);
        foyer2.setCapaciteFoyer(1L);
        foyer2.setIdFoyer(1L);
        foyer2.setNomFoyer("Nom Foyer");

        Universite universite2 = new Universite();
        universite2.setAdresse("Adresse");
        Foyer foyer3 = new Foyer();
        universite2.setFoyer(foyer3);
        universite2.setIdUniversite(1L);
        universite2.setNomUniversite("Nom Universite");
        foyer2.setUniversite(universite2);
        universite.setFoyer(foyer2);
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Nom Universite");
        foyer.setUniversite(universite);
        bloc.setFoyer(foyer);
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Nom Bloc");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(bloc));
        Object[] controllers = new Object[]{blocRestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link BlocRestController#getBlocswirhoutFoyer()}.
     * <p>
     * Method under test: {@link BlocRestController#getBlocswirhoutFoyer()}
     */
    @Test
    @DisplayName("Test getBlocswirhoutFoyer()")
    void testGetBlocswirhoutFoyer() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bloc/trouver-blocs-sans-foyer",
                uriVariables);
        Object[] controllers = new Object[]{blocRestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link BlocRestController#getBlocs()}.
     * <p>
     * Method under test: {@link BlocRestController#getBlocs()}
     */
    @Test
    @DisplayName("Test getBlocs()")
    void testGetBlocs() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bloc/retrieve-all-blocs", uriVariables);
        Object[] controllers = new Object[]{blocRestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }
}
