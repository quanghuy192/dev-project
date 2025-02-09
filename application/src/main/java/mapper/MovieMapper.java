package mapper;

import dto.MovieDTO;
import entities.Movie;
import org.mapstruct.factory.Mappers;

public abstract class MovieMapper {
    public static final MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    public abstract Movie fromDTO(MovieDTO movieDTO);
}
