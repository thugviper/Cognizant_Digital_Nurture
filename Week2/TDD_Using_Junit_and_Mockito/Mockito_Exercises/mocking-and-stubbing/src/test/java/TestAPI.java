import org.example.APIService;
import org.example.ExternalAPI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TestAPI {
    @Test
    public void testAPIService(){
        ExternalAPI mockAPI = Mockito.mock(ExternalAPI.class);
        when(mockAPI.getData()).thenReturn("Mocked Data");

        APIService apiService = new APIService(mockAPI);

        assertEquals("Mocked Data", apiService.fetchData());
    }
}
