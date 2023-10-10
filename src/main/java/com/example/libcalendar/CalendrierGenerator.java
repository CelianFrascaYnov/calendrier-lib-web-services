package com.example.libcalendar;

import com.example.libcalendar.model.MoisCalendrier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe génère un calendrier pour un mois et une année donnés.
 */
public class CalendrierGenerator {

    /**
     * Génère un calendrier pour un mois et une année donnés.
     *
     * @param annee L'année du calendrier.
     * @param mois  Le mois du calendrier (1 pour janvier, 2 pour février, etc.).
     * @return Une liste de {@link MoisCalendrier} contenant le calendrier généré.
     */
    // ...

    public MoisCalendrier generateCalendrier(int annee, int mois) {
        MoisCalendrier calendar = new MoisCalendrier();
        List<List<Integer>> entier = new ArrayList<>();

        // Créez une LocalDate pour le premier jour du mois
        LocalDate date = LocalDate.of(annee, mois, 1);

        // Déterminez le jour de la semaine du premier jour du mois
        DayOfWeek firstDayOfWeek = date.getDayOfWeek();

        // Ajoutez des jours vides au début du calendrier pour atteindre le premier jour de la semaine (lundi)
        int daysUntilMonday = (firstDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue() + 7) % 7;
        List<Integer> week = new ArrayList<>();
        for (int i = 0; i < daysUntilMonday; i++) {
            week.add(null);
        }

        // Ajoutez les jours du mois au calendrier
        while (date.getMonthValue() == mois) {
            week.add(date.getDayOfMonth());
            if (week.size() == 7) {
                entier.add(week);
                week = new ArrayList<>();
            }
            date = date.plusDays(1);
        }

        // Ajoutez des jours vides à la fin du calendrier pour compléter la dernière semaine
        while (week.size() < 7) {
            week.add(null);
        }
        entier.add(week);
        calendar.setSemaineMois(entier);
        return calendar;
    }
}