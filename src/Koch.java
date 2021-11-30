public class Koch {

    public static void main(String[] args) {
        Point startPoint = new Point(0, 0);
        Point endPoint = new Point(1000, 0);
        int depth = args.length > 0 ? Integer.parseInt(args[0]) : InputReader.readInt("Depth: ");
        // you can use also
        // int depth =3;
        Flake flake = new Flake(startPoint, endPoint);
        flake.recursiveSnow(startPoint, endPoint, depth);

        Flake flakeIterative = new Flake(startPoint, endPoint);
        flakeIterative.snow(depth);

        paintFlake(flake);
        paintFlake(flakeIterative);
    }

    static void paintFlake(Flake flake) {
        SimplePad pad = new SimplePad(1000, 450, "Koch Snow Flake");
        for (int i = 0; i < flake.getPoints().size() - 1; i++) {
            Point p1 = flake.getPoints().get(i);
            Point p2 = flake.getPoints().get(i+1);
            pad.drawLine(p1.getX(), 400 - p1.getY(), p2.getX(), 400 - p2.getY());
        }
        pad.setVisible();
    }
}
