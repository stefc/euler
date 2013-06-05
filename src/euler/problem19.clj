(ns euler.problem19)

(defn century-of-year [y] (int (/ y 100)))

(defn year-in-century [y] (- y (* (century-of-year y) 100 )))

(defn year [y] (mod (+ (year-in-century y) (int ( / (year-in-century y) 4))) 7))

(defn century [y] (* (- 3 (mod (century-of-year y) 4 )) 2 ))

(defn month [m] (nth [0 3 3 6 1 4 6 2 5 0 3 5] m ))

(defn day [d] (mod d 7))

(defn leapyear? [y] 
   (or
      (and
         (zero? (rem y 4))
            (not(zero? (rem y 100))))
               (zero? (rem y 400))))

(defn weekday [d m y] 
   (mod (+ (day d) (month m) (year y) (century y) (if (and (< m 2) (leapyear? y)) 6 0)) 7))

(defn count-sunday [y]
   (count (filter zero? (map #(weekday 1 % y) (range 12)))))
(defn calc [] 
	(apply + (map #(count-sunday %) (range 1901 2001))))