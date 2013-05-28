(ns euler.problem1)

; Multiples of 3 and 5
; 
; Multiplier bestimmen
; Filter Funktion
; Reduce zum Aufsummieren
;
(defn calc [n] 
	(apply + (filter #(or 
			(zero? (rem % 5))
			(zero? (rem % 3)))
		(range n))))