package tn.esprit.rh.achat.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.AssertionErrors;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import java.util.ArrayList;
import java.util.Optional;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

    @Mock
    StockRepository stockRepo;

    @InjectMocks
    StockServiceImpl stockService;

    Stock stock = new Stock("test",10,10);

    List<Stock> listProduits = new ArrayList<Stock>() {
        {
            add(new Stock("test",10,10));
            add(new Stock("test",10,10));
        }
    };

    @Test
    public void findStockTest()
    {
        Mockito.when(stockRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock s = stockService.retrieveStock(1L);
        Assertions.assertNotNull(s);
    }
}
