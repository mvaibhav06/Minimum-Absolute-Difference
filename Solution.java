class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Map<Integer,List<List<Integer>>> temp = new HashMap<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]-arr[i] > min){
                    break;
                }
                List<Integer> list1 = new ArrayList<>();
                list1.add(arr[i]);
                list1.add(arr[j]);
                List<List<Integer>> out = new ArrayList<>();
                if(temp.containsKey(arr[j]-arr[i])){
                    out = temp.get(arr[j]-arr[i]);
                }
                out.add(list1);
                min = Math.min(min,arr[j]-arr[i]);
                temp.put(arr[j]-arr[i],out);
            }
        }
        return temp.get(min);
    }
}
