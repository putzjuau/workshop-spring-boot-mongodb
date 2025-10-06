package com.joaovictor.workshopmongo.config;

import com.joaovictor.workshopmongo.domain.Comment;
import com.joaovictor.workshopmongo.domain.Post;
import com.joaovictor.workshopmongo.domain.Users;
import com.joaovictor.workshopmongo.dto.AuthorDto;
import com.joaovictor.workshopmongo.dto.CommentDto;
import com.joaovictor.workshopmongo.repository.CommentRepository;
import com.joaovictor.workshopmongo.repository.PostRepository;
import com.joaovictor.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;


@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Users maria = new Users(null, "Maria Brown", "maria@gmail.com");
        Users alex = new Users(null, "alex Brown", "alex@gmail.com");
        Users bob = new Users(null, "bob Brown", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz Hoje!!!", new AuthorDto(maria));


        postRepository.saveAll((Arrays.asList(post, post2)));

        maria.getPost().addAll(Arrays.asList(post,post2));
        userRepository.save(maria);



        CommentDto comment = new CommentDto(null, "Boa viagem Mano!", sdf.parse("21/03/20218"), new AuthorDto(alex));
        CommentDto comment2 = new CommentDto(null, "Aproveite!", sdf.parse("21/03/20218"), new AuthorDto(bob));
        CommentDto comment3 = new CommentDto(null, "Tenha um ótimo dia!!", sdf.parse("21/03/20218"), new AuthorDto(alex));


        post.getComments().addAll(Arrays.asList(comment,comment2));
        post2.getComments().addAll(Arrays.asList(comment3));

        postRepository.saveAll((Arrays.asList(post, post2)));
    }
}
