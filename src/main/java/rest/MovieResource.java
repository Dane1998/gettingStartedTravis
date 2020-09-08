package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.MoviesDTO;
import entities.Movie;
import utils.EMF_Creator;
import facades.MovieFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movie")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    private static final MovieFacade FACADE = MovieFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieCount() {
        long count = FACADE.getMovieCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":" + count + "}";  //Done manually so no need for a DTO
    }

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieById(@PathParam("id") int id) {
        Movie movie = FACADE.getMovieById(id);
        return GSON.toJson(movie);
    }
    
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllMovie(){
        List<Movie> allMovies = FACADE.getAllMovies();
        return GSON.toJson(allMovies);
    }
    
    @Path("/title{title}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieByTitle(@PathParam("title")String title){
        List<Movie> movieList = FACADE.getMovieByTitle(title);
        return GSON.toJson(movieList);
    }
    
    @Path("simpleall")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getSimpleAllMovies(){
        MoviesDTO allMoviesDTO = new MoviesDTO(FACADE.getAllMovies());
        return GSON.toJson(allMoviesDTO);
    }

}
