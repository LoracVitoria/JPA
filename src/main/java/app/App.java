package app;

import models.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("aula_jpa");
        EntityManager entityManager = factory.createEntityManager();

        Veiculo v1 = new Veiculo(null, "Clio", "Renault", new Date());
        Veiculo v2 = new Veiculo(null, "Fusca", "VW", new Date());
        Veiculo v3 = new Veiculo(null, "Gol", "VW", new Date());


        entityManager.getTransaction().begin();
        entityManager.persist(v1);
        entityManager.persist(v2);
        entityManager.persist(v3);

        Veiculo buscado = entityManager.find(Veiculo.class,1);
        System.out.println(buscado);
        buscado.setNome("Clio 1.0");
        entityManager.remove(buscado);

        Query q = entityManager.createNativeQuery("select * from tb_veiculos", Veiculo.class);
        List<Veiculo> veiculos = ((Query) q).getResultList();
        for (Veiculo veiculo : veiculos){
            System.out.println(veiculo);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

        buscado.setNome("Fiat");

    }
}
