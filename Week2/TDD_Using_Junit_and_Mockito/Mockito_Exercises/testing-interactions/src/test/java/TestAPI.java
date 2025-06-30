import org.example.ExternalAPI;
import org.example.MyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class TestAPI {
    @Test
    public void testFetchData() {
        // Arrange
        ExternalAPI mockAPI = Mockito.mock(ExternalAPI.class);
        when(mockAPI.getData()).thenReturn("Mocked Data");

        MyService service = new MyService(mockAPI);

        service.fetchData();

        verify(mockAPI).getData();
    }
}
