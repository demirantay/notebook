# SSH

- Lets first view what wikipedia says : *"Secure Shell (SSH) is a cryptographic network protocol services securely over an unsecured network. SSH provides a secure channel over an unsecure network in a client-server architecture, connecting an ssh client applciation with a ssh-server"*  

- To give a example remember when you generated a ssh key for making pull requests or cloning a repository from github. The site requries a ssh key log in for your machine becuase it is a lot safer than the usual text based has login systems.

- There is an **EXCELLENT** reddit explanation of SSH's login explained like you are a 5 year old take a look: 
  > Another way of looking at it is the familiar box analogy. Imagine you want to send a briefcase of information to your friend across the US but need it to be locked so that thieves can't see it. Obviously you can't just put your own lock on there and send it because your friend doesn't have your key to that lock.

  > The box analogy offers a solution. You put your own lock on the bag and send it to your friend. There, your friend also puts HIS own lock and sends it back. You then unlock your own lock with your key, meaning that the only lock left is your friend's lock. Send it back, and they can easily unlock it and take a look at the information. This is foolproof because a thief would need to know both lock's keys to open the briefcase.

  > Computing uses a similar model but rather than locks and keys it uses one master lock that can be opened with combinations of three keys, one public key and two private ones that you and your friend each know. Also it takes into account the properties of prime numbers and modular arithmetic. When studying CS, I found that this [video](https://www.youtube.com/watch?v=YEBfamv-_do) helps a lot in understanding how the numberized process of locking and unlocking works.
