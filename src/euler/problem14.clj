(ns euler.problem14)


(defn collatz [n] 
   (letfn [( next [x] 
      (if (= x 1) 0
         (if (even? x) 
            (/ x 2) (inc (* 3 x )))))]
   (take-while #(not (zero? %)) 
      (map first 
         (iterate (fn [[a b]] [b (next b)]) [n (next n)])))))

(defn calc [n]
   (loop [i 1 acc 0 maxi 0]
      (if (> i n ) acc 
         (let [cnt (count (collatz i))]
            (if (> cnt  maxi) (recur (inc i) i cnt)
               (recur (inc i) acc maxi))))))