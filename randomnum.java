public class randomnum {

    public int randomint(int min, int max) {

        if (min < max)
        {int x = (int) (Math.random() * ((max - min) + 1)) + min;

            return x;}
        else {
            int x = (int) (Math.random() * ((min - max) + 1)) + max;

            return x;
        }



    }
}
