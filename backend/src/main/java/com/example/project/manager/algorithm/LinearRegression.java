package com.example.project.manager.algorithm;

import com.example.project.manager.domain.HResponseStatistic;

public class LinearRegression {
    private static final int[] ages = {40, 37, 27, 34, 44, 35, 26, 29, 30, 33};
    private static final int[] sexs = {1, 0, 1, 1, 0, 1, 1, 1, 1, 0};
    private static final int[] weights = {50, 55, 56, 58, 62, 74, 92, 78, 66, 61};
    private static final int[] blood = {130, 115, 124, 128, 120, 120, 130, 110, 140, 150};
    private static final int[] sugar = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
    private static final int[] result = {2, 1, 2, 1, 1, 1, 2, 2, 2, 2};

    private static final double learningRate = 1e-10;

    private static double args[] = {0.8, 0.8, 0.2, 0.2, 0.2};

    private static final int epochs = 10000000;

    private static double[] hValues = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    public static double[] pressureArgs = {0.7970501981830989, 0.6908573326941652, 0.19705019818142344, -0.17757463284969385, 0.2};

    public static double[] diabetesArgs = {0.7921955881259014, 0.5112367603818784, 0.19219558812011, -0.2526558891430117, 0.2};

    public static HResponseStatistic setProbilities(HResponseStatistic hrs) {
        if (hrs.getCheckupDate() == null || hrs.getWeight() == null
                || hrs.getHeight() == null || hrs.getBloodSugar() == null || hrs.getBloodPressureHigh() == null
                || hrs.getAge() == null || hrs.getSex() == null) {
            hrs.setDiabetesProbability(0.0);
            hrs.setHighPressureProbability(0.0);
            return hrs;
        }

        double pressure = Math.round(Math.abs(pressureArgs[0] +
                pressureArgs[1] * hrs.getAge() +
                pressureArgs[2] * hrs.getSex() +
                pressureArgs[3] * hrs.getBloodPressureHigh() +
                pressureArgs[4] * hrs.getWeight()) * 100) / 100.0;

        double diabetes = Math.round(Math.abs(diabetesArgs[0] +
                diabetesArgs[1] * hrs.getAge() +
                diabetesArgs[2] * hrs.getSex() +
                diabetesArgs[3] * hrs.getWeight() +
                diabetesArgs[4] * hrs.getBloodSugar()) * 100) / 100.0;

        hrs.setHighPressureProbability(pressure);
        hrs.setDiabetesProbability(diabetes);


        return hrs;
    }

    public static void calcPressure() {
        for (int epoch = 0; epoch < epochs; epoch++) {
            // calc hvalue
            for (int i = 0; i < ages.length; i++) {
                double hval = args[0] * 1;
                hval += args[1] * ages[i];
                hval += args[2] * sexs[i];
                hval += args[3] * blood[i];
                hval += args[4] * weights[i];
                hValues[i] = hval;
            }

            // update args
            for (int i = 0; i < args.length; i++) {
                double dj = 0;
                for (int idx = 0; idx < ages.length; idx++) {
                    if (i == 0) {
                        dj += (result[idx] - hValues[idx]) * 1;
                    } else if (i == 1) {
                        dj += (result[idx] - hValues[idx]) * ages[i];
                    } else if (i == 2) {
                        dj += (result[idx] - hValues[idx]) * sexs[i];
                    } else if (i == 3) {
                        dj += (result[idx] - hValues[idx]) * blood[i];
                    } else if (i == 4) {
                        dj += (result[idx] - hValues[idx]) * weights[i];
                    }
                }
                args[i] += dj * learningRate;
            }

            // calc loss
            double loss = 0;
            for (int i = 0; i < ages.length; i++) {
                double hval = args[0] * 1;
                hval += args[1] * ages[i];
                hval += args[2] * sexs[i];
                hval += args[3] * blood[i];
                hval += args[4] * weights[i];
//                hValues[i] = hval;

                loss += Math.pow((hval - result[i]), 2);
            }
            loss /= 2.0f;

            if (epoch % 1000 == 0) {
                System.out.println("Loss: " + loss);
                System.out.println("arg1: " + args[0] + ", arg2: " + args[1] + ", arg3: " + args[2] + ", arg4: " + args[3] + ", arg5: " + args[4]);
            }
        }
    }

    public static void calcDiabetes() {
        for (int epoch = 0; epoch < epochs; epoch++) {
            // calc hvalue
            for (int i = 0; i < ages.length; i++) {
                double hval = args[0] * 1;
                hval += args[1] * ages[i];
                hval += args[2] * sexs[i];
                hval += args[3] * weights[i];
                hval += args[4] * sugar[i];
                hValues[i] = hval;
            }

            // update args
            for (int i = 0; i < args.length; i++) {
                double dj = 0;
                for (int idx = 0; idx < ages.length; idx++) {
                    if (i == 0) {
                        dj += (result[idx] - hValues[idx]) * 1;
                    } else if (i == 1) {
                        dj += (result[idx] - hValues[idx]) * ages[i];
                    } else if (i == 2) {
                        dj += (result[idx] - hValues[idx]) * sexs[i];
                    } else if (i == 3) {
                        dj += (result[idx] - hValues[idx]) * weights[i];
                    } else if (i == 4) {
                        dj += (result[idx] - hValues[idx]) * sugar[i];
                    }
                }
                args[i] += dj * learningRate;
            }

            // calc loss
            double loss = 0;
            for (int i = 0; i < ages.length; i++) {
                double hval = args[0] * 1;
                hval += args[1] * ages[i];
                hval += args[2] * sexs[i];
                hval += args[3] * weights[i];
                hval += args[4] * sugar[i];
//                hValues[i] = hval;

                loss += Math.pow((hval - result[i]), 2);
            }
            loss /= 2.0f;

            if (epoch % 1000 == 0) {
                System.out.println("Loss: " + loss);
                System.out.println("arg1: " + args[0] + ", arg2: " + args[1] + ", arg3: " + args[2] + ", arg4: " + args[3] + ", arg5: " + args[4]);
            }
        }
    }

    public static void main(String[] args) {
        calcDiabetes();
    }


}
