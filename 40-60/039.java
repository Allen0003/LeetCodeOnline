//039
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return null;
        }
        Set<List<Integer>> results = new HashSet<>();
        this.getCombination(candidates, target, new ArrayList<>(), results);
        return results.stream().collect(Collectors.toList());
    }

    public void getCombination(int[] candidates, int target, List<Integer> result, Set<List<Integer>> results) {
        if (target == 0 && result != null) {
            Collections.sort(result);
            results.add(new ArrayList<>(result));
            return;
        }

        for (int candidate : candidates) {
            if (candidate <= target) {
                result.add(candidate);
                getCombination(candidates, target - candidate, result, results);
                result.remove(new Integer(candidate));
            }
        }
    }


//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        if (candidates == null) {
//            return null;
//        }
//        Set<List<Integer>> ans = new HashSet<>();
//        find(candidates, target, new ArrayList<>(), ans);
//        return ans.stream().collect(Collectors.toList());
//    }
//
//    public void find(int[] candidates, int target, List<Integer> current, Set<List<Integer>> ans) {
//        if (target == 0) {
//            Collections.sort(current);
//            ans.add(new ArrayList<>(current));
//            return;
//        }
//        for (int candidate : candidates) {
//            if (candidate <= target) {
//                current.add(candidate);
//                find(candidates, target - candidate, current, ans);
//                current.remove(new Integer(candidate));
//            }
//        }
//    }
