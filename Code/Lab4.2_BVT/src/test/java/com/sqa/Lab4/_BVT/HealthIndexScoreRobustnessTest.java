package com.sqa.Lab4._BVT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.sqa.Lab4._BVT.HealthIndexScore.FitnessLevel;

public class HealthIndexScoreRobustnessTest {

    @Test
    @DisplayName("TC001: VO2 Max = -1 (min-), RHR = 130 (nom), HRR = 15 (nom) -> Throws Exception")
    public void testTC001() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HealthIndexScore(-1.0, 130, 15);
        }, "Should throw IllegalArgumentException for negative VO2 Max");
    }

    @Test
    @DisplayName("TC002: VO2 Max = 0 (min), RHR = 130 (nom), HRR = 15 (nom)")
    public void testTC002() {
        HealthIndexScore score = new HealthIndexScore(0.0, 130, 15);
        assertEquals(4, score.getTotalScore(), "Total score should be 4");
        assertEquals(FitnessLevel.POOR, score.getFitnessLevel(), "Fitness Level should be POOR");
    }

    @Test
    @DisplayName("TC003: VO2 Max = 1 (min+), RHR = 130 (nom), HRR = 15 (nom)")
    public void testTC003() {
        HealthIndexScore score = new HealthIndexScore(1.0, 130, 15);
        assertEquals(4, score.getTotalScore(), "Total score should be 4");
        assertEquals(FitnessLevel.POOR, score.getFitnessLevel(), "Fitness Level should be POOR");
    }

    @Test
    @DisplayName("TC004: VO2 Max = 43 (nom), RHR = 130 (nom), HRR = 15 (nom)")
    public void testTC004() {
        HealthIndexScore score = new HealthIndexScore(43.0, 130, 15);
        assertEquals(7, score.getTotalScore(), "Total score should be 7");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }

    @Test
    @DisplayName("TC005: VO2 Max = 60 (max-), RHR = 130 (nom), HRR = 15 (nom)")
    public void testTC005() {
        HealthIndexScore score = new HealthIndexScore(60.0, 130, 15);
        assertEquals(8, score.getTotalScore(), "Total score should be 8");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }

    @Test
    @DisplayName("TC006: VO2 Max = 61 (max), RHR = 130 (nom), HRR = 15 (nom)")
    public void testTC006() {
        HealthIndexScore score = new HealthIndexScore(61.0, 130, 15);
        assertEquals(9, score.getTotalScore(), "Total score should be 9");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }

    @Test
    @DisplayName("TC007: VO2 Max = 62 (max+), RHR = 130 (nom), HRR = 15 (nom)")
    public void testTC007() {
        HealthIndexScore score = new HealthIndexScore(62.0, 130, 15);
        assertEquals(9, score.getTotalScore(), "Total score should be 9");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }

    @Test
    @DisplayName("TC008: VO2 Max = 43 (nom), RHR = 39 (min-), HRR = 15 (nom) -> Throws Exception")
    public void testTC008() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HealthIndexScore(43.0, 39, 15);
        }, "Should throw IllegalArgumentException for RHR < 40");
    }

    @Test
    @DisplayName("TC009: VO2 Max = 43 (nom), RHR = 40 (min), HRR = 15 (nom)")
    public void testTC009() {
        HealthIndexScore score = new HealthIndexScore(43.0, 40, 15);
        assertEquals(11, score.getTotalScore(), "Total score should be 11");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }

    @Test
    @DisplayName("TC010: VO2 Max = 43 (nom), RHR = 41 (min+), HRR = 15 (nom)")
    public void testTC010() {
        HealthIndexScore score = new HealthIndexScore(43.0, 41, 15);
        assertEquals(11, score.getTotalScore(), "Total score should be 11");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }

    @Test
    @DisplayName("TC011: VO2 Max = 43 (nom), RHR = 219 (max-), HRR = 15 (nom)")
    public void testTC011() {
        HealthIndexScore score = new HealthIndexScore(43.0, 219, 15);
        assertEquals(7, score.getTotalScore(), "Total score should be 7");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }

    @Test
    @DisplayName("TC012: VO2 Max = 43 (nom), RHR = 220 (max), HRR = 15 (nom)")
    public void testTC012() {
        HealthIndexScore score = new HealthIndexScore(43.0, 220, 15);
        assertEquals(7, score.getTotalScore(), "Total score should be 7");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }

    @Test
    @DisplayName("TC013: VO2 Max = 43 (nom), RHR = 221 (max+), HRR = 15 (nom) -> Throws Exception")
    public void testTC013() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HealthIndexScore(43.0, 221, 15);
        }, "Should throw IllegalArgumentException for RHR > 220");
    }

    @Test
    @DisplayName("TC014: VO2 Max = 43 (nom), RHR = 130 (nom), HRR = -1 (min-) -> Throws Exception")
    public void testTC014() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HealthIndexScore(43.0, 130, -1);
        }, "Should throw IllegalArgumentException for negative HRR");
    }

    @Test
    @DisplayName("TC015: VO2 Max = 43 (nom), RHR = 130 (nom), HRR = 0 (min)")
    public void testTC015() {
        HealthIndexScore score = new HealthIndexScore(43.0, 130, 0);
        assertEquals(5, score.getTotalScore(), "Total score should be 5");
        assertEquals(FitnessLevel.POOR, score.getFitnessLevel(), "Fitness Level should be POOR");
    }

    @Test
    @DisplayName("TC016: VO2 Max = 43 (nom), RHR = 130 (nom), HRR = 1 (min+)")
    public void testTC016() {
        HealthIndexScore score = new HealthIndexScore(43.0, 130, 1);
        assertEquals(5, score.getTotalScore(), "Total score should be 5");
        assertEquals(FitnessLevel.POOR, score.getFitnessLevel(), "Fitness Level should be POOR");
    }

    @Test
    @DisplayName("TC017: VO2 Max = 43 (nom), RHR = 130 (nom), HRR = 29 (max-)")
    public void testTC017() {
        HealthIndexScore score = new HealthIndexScore(43.0, 130, 29);
        assertEquals(9, score.getTotalScore(), "Total score should be 9");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }

    @Test
    @DisplayName("TC018: VO2 Max = 43 (nom), RHR = 130 (nom), HRR = 30 (max)")
    public void testTC018() {
        HealthIndexScore score = new HealthIndexScore(43.0, 130, 30);
        assertEquals(9, score.getTotalScore(), "Total score should be 9");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }

    @Test
    @DisplayName("TC019: VO2 Max = 43 (nom), RHR = 130 (nom), HRR = 31 (max+)")
    public void testTC019() {
        HealthIndexScore score = new HealthIndexScore(43.0, 130, 31);
        assertEquals(9, score.getTotalScore(), "Total score should be 9");
        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel(), "Fitness Level should be STANDARD");
    }
}