class Solution {
    public String simplifyPath(String path) {
        Deque<String> pathStack = new ArrayDeque<>();
        StringBuilder currentDir = new StringBuilder();
        for (int i = 0; i <= path.length(); i++) {
            if (i == path.length() || path.charAt(i) == '/') {
                if (currentDir.length() > 0) {
                    String directory = currentDir.toString();
                    if (directory.equals("..")) {
                        if (!pathStack.isEmpty())
                            pathStack.pop();
                    } else if (!directory.equals(".")) {
                        pathStack.push(directory);
                    }
                    currentDir.setLength(0);
                }
            } else {
                currentDir.append(path.charAt(i));
            }
        }

        if (pathStack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();

        while (!pathStack.isEmpty()) {
            result.append('/');
            result.append(pathStack.removeLast());
        }

        return result.toString();
    }
}