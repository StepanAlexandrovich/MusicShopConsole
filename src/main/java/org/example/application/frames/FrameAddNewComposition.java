package org.example.application.frames;

import org.example.Helper;
import org.example.Top;
import org.example.application.frames.helpers.FrameImitation;
import org.example.application.frames.helpers.FramePassage;
import org.example.model.Genre;
import org.example.model.Performer;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FrameAddNewComposition extends FramePassage {
    private String name;
    private LocalDate dateRelease;
    private Double duration;
    private Double price;
    private int genreId;
    private int performerId;

    @Override
    public void startInput(Scanner scanner) {
        Helper.printLine("Введите название песни");
        name = scanner.next();

        Helper.printLine("Введите год выпуска песни");
        int year = scanner.nextInt();
        Helper.printLine("Введите месяц выпуска песни(int)");
        int month = scanner.nextInt();
        Helper.printLine("Введите число месяца выпуска песни(int)");
        int day = scanner.nextInt();
        dateRelease = LocalDate.of(year,month,day);

        Helper.printLine("Введите продолжительность песни(double)");
        duration = scanner.nextDouble();
        Helper.printLine("Введите цену для песни(double)");
        price = scanner.nextDouble();

        List<Genre> genres = Top.genreService.getAll();
        Helper.printList("Выберите жанр из списка доступных",genres);
        genreId = genres.get(scanner.nextInt() - 1).getId();

        List<Performer> performers = Top.performerService.getAll();
        Helper.printList("Выберите исполнителя из списка доступных",performers);
        performerId = performers.get(scanner.nextInt() - 1).getId();
    }

    @Override
    public boolean result() {
        return Top.compositionService.add(name,dateRelease,duration,price,genreId,performerId) != null;
    }

    @Override
    public void messageSuccess() {
        Helper.printLine("Композиция успешно добавлена");
        standardMessageSuccess();
    }
    @Override
    public FrameImitation getNextFrame() {
        return null;
    }
    @Override
    public void messageFailure() {
        Helper.printLine("Композиция не добавлена");
        standardMessageFailure();
    }
}
