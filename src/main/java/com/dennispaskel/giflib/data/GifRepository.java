package com.dennispaskel.giflib.data;

import com.dennispaskel.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Acts as a hardcoded data storage in lieu of a database for the moment
@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", 3, LocalDate.of(2021,3,13), "ArmyMP", false),
            new Gif("ben-and-mike", 2, LocalDate.of(2021,3,13), "ArmyMP", true),
            new Gif("book-dominos", 1, LocalDate.of(2021,3,14), "ThatArmyGuy", false),
            new Gif("compiler-bot", 1, LocalDate.of(2021,3,14), "ThatArmyGuy", true),
            new Gif("cowboy-coder", 1, LocalDate.of(2021,3,15), "ArmyMP", false),
            new Gif("infinite-andrew", 2, LocalDate.of(2021,3,15), "ThatArmyGuy", true)
    );

    public Gif findByName(String name) {
        for(Gif gif : ALL_GIFS) {
            if(gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id) {
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS) {
            if (gif.getCategoryId() == id) {
                gifs.add(gif);
            }
        }
        return gifs;
    }
}
