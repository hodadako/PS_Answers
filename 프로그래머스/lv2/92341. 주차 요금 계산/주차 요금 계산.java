import java.util.*;

class Solution {
    public class Car {
        public String in;
        public String out;
        public int time;
        public int carNum;
        
        public Car(String in, int carNum) {
            this.in = in;
            this.out = "";
            this.carNum = carNum;
            this.time = 0;
        }
        
        public String getIn() {
            return this.in;
        }
        
        public int getTime() {
            return this.time;
        }
        
        public int getCarNum() {
            return this.carNum;
        }
        
        public void setIn(String in) {
            this.in = in;
        }
        
        public void setOut(String out) {
            this.out = out;
        }
        
        public void updateTime() {
            String[] inArr = this.in.split(":");
            String[] outArr = this.out.split(":");
            int hour = 0, minute = 0;
            
            if (Integer.parseInt(outArr[1]) >= Integer.parseInt(inArr[1])) {
                hour = Integer.parseInt(outArr[0]) - Integer.parseInt(inArr[0]);
                minute = Integer.parseInt(outArr[1]) - Integer.parseInt(inArr[1]); 
            } else {
                hour = Integer.parseInt(outArr[0]) - Integer.parseInt(inArr[0]) -1;
                minute = Integer.parseInt(outArr[1]) - Integer.parseInt(inArr[1]) + 60;
            }
            
            this.in = "";
            this.out = "";
            this.time += hour * 60 + minute;
            
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Car> cars = new ArrayList<>();
        HashMap<Integer, Car> map = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");
            if (map.containsKey(Integer.parseInt(info[1]))) {
                if (info[2].equals("IN")) {
                    Car car = map.get(Integer.parseInt(info[1]));
                    car.setIn(info[0]);
                    map.put(Integer.parseInt(info[1]), car);
                } else {
                    Car car = map.get(Integer.parseInt(info[1]));
                    car.setOut(info[0]);
                    car.updateTime();
                    map.put(Integer.parseInt(info[1]), car);
                }
            } else {
                Car car = new Car(info[0], Integer.parseInt(info[1]));
                map.put(Integer.parseInt(info[1]), car);
            }
        }
        
        for (Integer key: map.keySet()) {
            Car car = map.get(key);
            if (!car.getIn().equals("")){
                car.setOut("23:59");
                car.updateTime();
            }
            cars.add(car);
        }
        
        Collections.sort(cars, (o1, o2) -> o1.getCarNum() - o2.getCarNum());
        int[] answer = new int[cars.size()];
        for (int i = 0; i < answer.length; i++) {
            int cur = cars.get(i).getTime();
            System.out.println((int) Math.ceil((cur - fees[0]) / Double.valueOf(fees[2])));
            int price = fees[1];
            if (cur <= fees[0]) {
                answer[i] = price;
            } else {
                answer[i] = (int) Math.ceil((cur - fees[0]) / Double.valueOf(fees[2])) * fees[3] + price;
            }
        }
        return answer;
    }
}