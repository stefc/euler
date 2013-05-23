(ns euler.core
  (:gen-class))

; Multiples of 3 and 5
; 
; Multiplier bestimmen
; Filter Funktion
; Reduce zum Aufsummieren
;
(defn no1 [n]
	(reduce + (filter (fn [x] (or 
			(zero? (mod x 5))
			(zero? (mod x 3))))
		(range n))))

(defn -main [& args]
  (println (format "Problem No %d = %d" 1 (no1 1000))))
