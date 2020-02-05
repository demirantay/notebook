> I WILL RE-ARRANGE THIS NOTES, THISIS JUSTA STARTING POINT. SINCE I DO NOT HAVE A LOT OF NETWORKING KNOWLEDGE AT THE MOMENT I AM GOING TO LEAVE IT AS IT IS.

# CDN (Content Delivery Network)

- A CDN is a network of computers that delivers content.

  More specifically, it’s a bunch of servers geographically positioned between the origin server of some web content, and the user requesting it, all with the purpose of delivering the content faster by reducing latency. This is their primary purpose.

  These geographically closer servers, also called PoPs or Points of Presence, also cache the cacheable content which removes a lot of the load from the origin server. There are different types of CDNs offering different kinds of services, and they can have differing network topology: scattered CDNs aim to have as many servers scattered around the world as possible. Akamai is one such CDN. Consolidated CDNs have fewer points, but bigger ones built for network performance, throughput, and DDoS resistance.
  
### Types of CDN's
  
- We said that their primary purpose was to reduce latency and speed up rendering. But in the modern world of 2MB images and 500kb JavaScript libraries that take 3 minutes to boot up on websites, this latency matters little. But there are other purposes to CDNs, too, which evolved over time.

- `Content-oriented CDNs` -- Initially, CDNs were just for static content (JS, CSS, HTML). You had to push content to them as you created/uploaded it (they didn’t know they needed to update their cache with your content, not even as someone requested it).

  Then, they added origin pulling, making things more automatic – this meant that a user requested the CDN’s URL, and then the CDN requested the origin website’s URL automatically, caching what ever it got back. Additionally, availability became an important factor. Many CDNs now cache a website’s “last alive” state so that if the origin goes down, the CDNed content is still accessible to users, creating the illusion of stability until things return to normal.

- `Security-oriented CDNs` -- The final layer of practicality added to CDNs was DDoS and bot protection. CDNs like Incapsula specialize in this.

  As the CDN is the outermost layer of a website’s infrastructure and the first recipient of traffic, it can detect DDoS attacks early and block them with special DDoS protection servers called scrubbers without them ever reaching the origin server and crashing it.

### Biggest Players

- Some of the biggest players in the CDN space are companies like Akamai, AWS Cloudfront, Cloudinary, Incapsula, MaxCDN, Fastly, and others.

### Implementation Process

- Implementing a CDN typically entails changing some DNS records in the control panel of the registrar (the company renting you your domain name). This results in all traffic hitting the CDN first, which in turn hits your website. Since it all happens behind the scenes (through IPs), the process is transparent to the user.

<BR>
<BR>
<BR>

---

<br>

# StackOverflow Explanation

### It simply Decrease Server Load

- As a result, the strategic placement can decrease the server load on interconnects, backbones and public and private peers, which frees up overall capacity and decreases delivery costs. Essentially, the content is spread out across several servers, as opposed to offloading them onto one large server.

### Make Faster Content Delivery

- Since CDNs place servers as close to a group of users as possible, latency and packet loss are minimized due to a shorter distance traveled. Theoretically, the closer the content is to the user, the faster the delivery. Therefore, users will experience less jitter when streaming, fewer network spikes, and an overall improved streaming quality. Due to the reliability, operators can deliver high quality content with a high level of service, low network server loads, and thus, lower costs.

  Additionally, many CDN providers offer TCP acceleration technology which boosts performance, thus improving user experience. Since CDNs decrease latency, the acceleration working in conjunction with an already high-performing network results in explosive content.

### 100 Percent Availability

- Due to the distribution of assets across many regions, CDNs have automatic server availability sensing mechanisms with instant user redirection. As a result, CDN websites experience 100 percent availability, even during massive power outages, hardware issues or network problems.

### Increase in the number of Concurrent Users

- Strategically placing the servers in a CDN can result in high network backbone capacity, which equates to a significant increase in the number of users accessing the network at a given time. For example, where there is a 100 GB/s network backbone with 2 tb/s capacity, only 100 GB/s can be delivered. However, with a CDN, 10 servers will be available at 10 strategic locations and can then provide a total capacity of 10 x 100 GB/s.

### Control of Asset Delivery

- Another beneficial feature of CDN technology is that more control of asset delivery and network load is awarded. Operators have the ability to deliver real-time load statistics, optimize capacity per customer, display active regions, indicate which assets are popular, and report viewing details to their customers. These details are extremely important, since usage logs are deactivated once the server source has been added to the CDN.
