package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

   

    public long getMovieCount(){
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createNamedQuery("Movie.getMovieCount");
            Long movieCount = (long) query.getSingleResult();
            return movieCount;
        }finally{  
            em.close();
        }
    }
    
    public Movie getMovieById(long id){
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createNamedQuery("Movie.getMovieById");
            query.setParameter("id", id);
            Movie movie = (Movie) query.getSingleResult();
            return movie;
        }finally{
            em.close();
        }
    }
    
    public List<Movie> getMovieByTitle(String title){
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createNamedQuery("Movie.getByTitle");
            query.setParameter("title", title);
            List<Movie> movieList = query.getResultList();
            return movieList;
        }finally{
            em.close();
        }
    }
    
    public List<Movie> getAllMovies(){
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createNamedQuery("Movie.getAll");
            List<Movie> allMovies = query.getResultList();
            return allMovies;
        }finally{
            em.close();
        }
    }
    
    public void deleteAllMovies(){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.createNamedQuery("Movie.deleteAllRows").executeUpdate();
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    

}
