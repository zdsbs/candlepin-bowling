(ns scorecard)

(defn third [rolls]
	(first (next (next rolls))))

(defn first-two [rolls]
	(+ (first rolls) (second rolls)))

(defn strike? [rolls]
	(= 10 (first rolls)))

(defn spare? [rolls]
	(= 10 (first-two rolls)))

(defn remove-strike [rolls]
	(rest rolls))

(defn remove-spare [rolls]
	(rest (rest rolls)))

(defn remove-normal-frame [rolls]
	(rest (rest (rest rolls))))

(defn remove-frame [rolls]
		(if (strike? rolls)
			(remove-strike rolls)
			(if (spare? rolls)
				(remove-spare rolls)
				(remove-normal-frame rolls))))

(defn score [input-rolls]
	(loop [rolls input-rolls score 0 frame-counter 0]
		(if (or (empty? rolls) (= 10 frame-counter))
			score
			(recur 
				(remove-frame rolls) 
				(+ score (first rolls) (second rolls) (third rolls)) (inc frame-counter)))))