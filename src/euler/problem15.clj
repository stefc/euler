(ns euler.problem15)

(defn factorial [n] 
   (apply * (range 1N (bigint(inc n)))))

(defn bio-coe [n k]
   (/ (factorial n) (* (factorial k) (factorial (- n k)))))

(defn calc [n]
	(bio-coe (+ n n) n))