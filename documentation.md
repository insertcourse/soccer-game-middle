soccer game middle

Player {
name ( VO )
final static Integer chance
}

Attacker Extends Player {
Integer goals

shoot ( )
}

Striker extends Attacker {
chance = 2
}

Midfielder extends Attacker {
chance = 1

shoot ( )
}

GoalKeeper extends Player {
chance = 3

saves ( 3 ~ 7 )
}

SoccerGame {
winner
List<Attacker> attackers;
GoalKeeper goalkeeper;
final matchpoint = 0;
final Winner winner;

    init(){
    	settingPlayer()
    }

    setMatchPoint() {
    	matchpoint = set
    }

    start(){
    	while(matchpoint != 0) {
    		shooting()
    		checkMatch()
    		printshooting()

    	}
    }


    printshooting(){

    }

    shootings () {
    	forEach Attackers {
    		checkGoals()
    		checkMatchPoints()
    	}
    }

    checkMatchPoints() {
    	if matchpoint == goals  {
    		winner = name
    	}
    }

    checkGoals(Attackers) {
    	shoot = [ ]
    	for attackers.shoot
    	goalkeepr.keep

    	if shoot != keep {
    		attackers.goal()
    	}
    }

    setMatchPoint( matchpoint ){ this.matchpoint = matchpoint }

    setting {
    	setStriker()
    	setMidfielder()
    	setGoalkeeper()
    }

    set … {
    	input(“입력”)
    	new

    	attackers add
    }

    setGoalkeeper {
    	goalkeeper = new GoalKeeper(“오예스”);
    }

}
