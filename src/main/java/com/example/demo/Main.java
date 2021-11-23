package com.example.demo;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 200;
    public static final int DEFAULT_ANGLE = 30;
    public static MeshView createOctahedron(int length){
        TriangleMesh trianglemesh = new TriangleMesh();
        trianglemesh.getPoints().addAll(
                length,    0.0f,    0.0f,
                -length,    0.0f,    0.0f,
                0.0f,  length,    0.0f,
                0.0f, -length,    0.0f,
                0.0f,    0.0f,  length,
                0.0f,    0.0f, -length
        );
        trianglemesh.getTexCoords().addAll(
                0.50f, 1.00f,
                0.75f, (float) (1.0-Math.sqrt(3.0)/4.0f),
                0.25f, (float) (1.0-Math.sqrt(3.0)/4.0f),
                1.00f, 1.00f,
                0.50f, (float) (1.0-Math.sqrt(3.0)/2.0f),
                0.00f, 1.00f
        );
        trianglemesh.getFaces().addAll(
                4, 0, 0, 1, 2, 2,
                4, 1, 2, 0, 1, 3,
                4, 2, 1, 1, 3, 4,
                4, 0, 3, 2, 0, 5,
                5, 0, 2, 2, 0, 5,
                5, 2, 1, 1, 2, 4,
                5, 1, 3, 0, 1, 3,
                5, 0, 0, 1, 3, 2
        );
        trianglemesh.getFaceSmoothingGroups().addAll(
                0, 2, 4, 8, 16, 32, 64, 128
        );
        MeshView meshview = new MeshView(trianglemesh);
        return meshview;
    }

    public static MeshView createTetrahedron(int length){
        float p0 = length*1.0f;
        float p1 = 0.0f;
        float p2 = (float) (length*Math.sqrt(2.0)/2.0f);
        TriangleMesh trianglemesh = new TriangleMesh();
        trianglemesh.getPoints().addAll(
                p0, p1, -p2,
                -p0, p1, -p2,
                p1, p0, p2,
                p1, -p0, p2
        );
        trianglemesh.getTexCoords().addAll(
                0.50f, 1.00f,
                0.75f, (float) (1.0-Math.sqrt(3.0)/4.0f),
                0.25f, (float) (1.0-Math.sqrt(3.0)/4.0f),
                1.00f, 1.00f,
                0.50f, (float) (1.0-Math.sqrt(3.0)/2.0f),
                0.00f, 1.00f
        );
        trianglemesh.getFaces().addAll(
                0, 0, 1, 1, 2, 2,
                1, 1, 0, 0, 3, 3,
                2, 2, 1, 1, 3, 4,
                0, 0, 2, 2, 3, 5
        );
        trianglemesh.getFaceSmoothingGroups().addAll(0, 2, 4, 8);
        MeshView meshview = new MeshView(trianglemesh);
        return meshview;
    }

    public static MeshView createDodecahedron(int length){
        float p0 = (float) (length*1.0/Math.sqrt(3.0f));
        float p1 = (float) (length*Math.sqrt((3.0-Math.sqrt(5.0))/6.0));
        float p2 = (float) (length*Math.sqrt((3.0+Math.sqrt(5.0))/6.0));
        float p3 = 0.0f;
        TriangleMesh trianglemesh = new TriangleMesh();
        trianglemesh.getPoints().addAll(
                p0,  p0,  p0,
                p0,  p0, -p0,
                p0, -p0,  p0,
                p0, -p0, -p0,
                -p0,  p0,  p0,
                -p0,  p0, -p0,
                -p0, -p0,  p0,
                -p0, -p0, -p0,
                p1,  p2,  p3,
                -p1,  p2,  p3,
                p1, -p2,  p3,
                -p1, -p2,  p3,
                p2,  p3,  p1,
                p2,  p3, -p1,
                -p2,  p3,  p1,
                -p2,  p3, -p1,
                p3,  p1,  p2,
                p3, -p1,  p2,
                p3,  p1, -p2,
                p3, -p1, -p2
        );
        trianglemesh.getTexCoords().addAll(
                0.50f, 1.00f,
                0.75f, (float) (1.0-Math.sqrt(3.0)/4.0f),
                0.25f, (float) (1.0-Math.sqrt(3.0)/4.0f),
                1.00f, 1.00f,
                0.50f, (float) (1.0-Math.sqrt(3.0)/2.0f),
                0.00f, 1.00f
        );
        trianglemesh.getFaces().addAll(
                0, 2,  8, 1,  9, 4,
                0, 2,  9, 1,  4, 4,
                0, 2,  4, 1, 16, 4,
                0, 2, 12, 1, 13, 4,
                0, 2, 13, 1,  1, 4,
                0, 2,  1, 1,  8, 4,
                0, 2, 16, 1, 17, 4,
                0, 2, 17, 1,  2, 4,
                0, 2,  2, 1, 12, 4,
                8, 2,  1, 1, 18, 4,
                8, 2, 18, 1,  5, 4,
                8, 2,  5, 1,  9, 4,
                12, 2,  2, 1, 10, 4,
                12, 2, 10, 1,  3, 4,
                12, 2,  3, 1, 13, 4,
                16, 2,  4, 1, 14, 4,
                16, 2, 14, 1,  6, 4,
                16, 2,  6, 1, 17, 4,
                9, 2,  5, 1, 15, 4,
                9, 2, 15, 1, 14, 4,
                9, 2, 14, 1,  4, 4,
                6, 2, 11, 1, 10, 4,
                6, 2, 10, 1,  2, 4,
                6, 2,  2, 1, 17, 4,
                3, 2, 19, 1, 18, 4,
                3, 2, 18, 1,  1, 4,
                3, 2,  1, 1, 13, 4,
                7, 2, 15, 1,  5, 4,
                7, 2,  5, 1, 18, 4,
                7, 2, 18, 1, 19, 4,
                7, 2, 11, 1,  6, 4,
                7, 2,  6, 1, 14, 4,
                7, 2, 14, 1, 15, 4,
                7, 2, 19, 1,  3, 4,
                7, 2,  3, 1, 10, 4,
                7, 2, 10, 1, 11, 4
        );
        trianglemesh.getFaceSmoothingGroups().addAll(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        );
        MeshView meshview = new MeshView(trianglemesh);
        return meshview;
    }
    @Override
    public void start(Stage primaryStage) {
        Box box = new Box(100, 100, 100);
        box.translateXProperty().set(200);
        box.translateYProperty().set(100);
        box.getTransforms().add(new Rotate(DEFAULT_ANGLE, Rotate.X_AXIS));
        box.getTransforms().add(new Rotate(DEFAULT_ANGLE, Rotate.Y_AXIS));
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.DARKGREY);
        box.setMaterial(material);

        MeshView octahedron = createOctahedron(100);
        octahedron.translateXProperty().set(400);
        octahedron.translateYProperty().set(100);
        octahedron.getTransforms().add(new Rotate(DEFAULT_ANGLE, Rotate.X_AXIS));
        octahedron.getTransforms().add(new Rotate(DEFAULT_ANGLE, Rotate.Y_AXIS));
        PhongMaterial material0 = new PhongMaterial();
        material0.setDiffuseColor(Color.ROSYBROWN);
        octahedron.setMaterial(material0);

        MeshView dodecahedron = createDodecahedron(100);
        dodecahedron.translateXProperty().set(600);
        dodecahedron.translateYProperty().set(100);
        dodecahedron.getTransforms().add(new Rotate(DEFAULT_ANGLE, Rotate.X_AXIS));
        dodecahedron.getTransforms().add(new Rotate(DEFAULT_ANGLE, Rotate.Y_AXIS));
        PhongMaterial material3 = new PhongMaterial();
        material3.setDiffuseColor(Color.CHOCOLATE);
        dodecahedron.setMaterial(material3);


        MeshView tetrahedron = createTetrahedron(100);
        tetrahedron.translateXProperty().set(810);
        tetrahedron.translateYProperty().set(125);
        tetrahedron.getTransforms().add(new Rotate(DEFAULT_ANGLE, Rotate.X_AXIS));
        tetrahedron.getTransforms().add(new Rotate(DEFAULT_ANGLE, Rotate.Y_AXIS));
        PhongMaterial material2 = new PhongMaterial();
        material2.setDiffuseColor(Color.HOTPINK);
        tetrahedron.setMaterial(material2);

        Group group = new Group();
        group.getChildren().add(octahedron);
        group.getChildren().add(dodecahedron);
        group.getChildren().add(box);
        group.getChildren().add(tetrahedron);

        Scene scene = new Scene(group, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}