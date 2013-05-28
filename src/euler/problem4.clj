(ns euler.problem4)

(defn calc [n] 
	(letfn [
		(pow10 [e] (int(Math/pow 10 e)))
		(palindrom? [vec] (= vec (reverse vec)))
		(split [n digits] 
			(loop [v n idx digits acc []]
				(let [weight (pow10 (dec idx))]
					(if(zero? idx) acc 
						(recur (- v (* weight (int(/ v weight)) )) (dec idx) (conj acc (int(/ v  weight))))))))	
		(products [n] 
			(filter #(palindrom? (split % n)) 
				(for [a (range 99 999) b (range 99 999 11)] (* a b))))
		](apply max (products (+ n n)))))
