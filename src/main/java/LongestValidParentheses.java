import java.util.ArrayList;
import java.util.List;

public class LongestValidParentheses {
    public int getLongest(String str1) {
        List<ValidStringIndexes> validStringIndexesList = new ArrayList<>();
        int currentStartIndex = 0;
        int currentEndIndex = str1.length() - 1;

        while (true) {
            ValidStringIndexes validStringIndexes = getFirstValidStringIndexes(str1, currentStartIndex, currentEndIndex);
            if (validStringIndexes.startIndex == -1)
                break;

            validStringIndexesList.add(validStringIndexes);

            if (validStringIndexes.endIndex == str1.length() - 1)
                break;

            currentStartIndex = validStringIndexes.endIndex + 1;
        }

        return getMaxFromList(validStringIndexesList);
    }

    public ValidStringIndexes getFirstValidStringIndexes(String str, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            if (str.charAt(i) == '(' && str.charAt(i + 1) == ')') {
                int width = 0;
                int leftMargin = i - width;
                int rightMargin = i + width + 1;

                if (leftMargin >= startIndex && rightMargin <= endIndex - 1) {
                    while (leftMargin - 1 >= startIndex && rightMargin + 1 < endIndex &&
                            str.charAt(leftMargin - 1) == '(' && str.charAt(rightMargin + 1) == ')') {
                        width++;
                        leftMargin--;
                        rightMargin++;
                    }
                }
                return new ValidStringIndexes(leftMargin, rightMargin);
            }
        }

        return new ValidStringIndexes(-1, -1);
    }

    private int getMaxFromList(List<ValidStringIndexes> validStringIndexesList) {
        int max = 0;

        if(validStringIndexesList.size() == 1)
            return validStringIndexesList.stream().findFirst().get().getSize();

        for (int i = 0; i < validStringIndexesList.size() - 1; i++) {
            if (validStringIndexesList.get(i).getMaxCombinedSize(validStringIndexesList.get(i + 1)) > max)
                max = validStringIndexesList.get(i).getMaxCombinedSize(validStringIndexesList.get(i + 1));
        }

        return max;
    }

}

class ValidStringIndexes {
    public int startIndex;
    public int endIndex;

    public ValidStringIndexes(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getSize() {
        return endIndex - startIndex + 1;
    }

    public int getMaxCombinedSize(ValidStringIndexes validStringIndexes) {
        ValidStringIndexes laterString = validStringIndexes.startIndex > startIndex ? validStringIndexes : this;
        ValidStringIndexes earlierString = validStringIndexes.startIndex < startIndex ? validStringIndexes : this;
        if (earlierString.endIndex + 1 == laterString.startIndex)
            return laterString.getSize() + earlierString.getSize();
        else
            return laterString.getSize() > earlierString.getSize() ? laterString.getSize() : earlierString.getSize();
    }
}