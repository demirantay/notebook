# Caching

- In computing, a cache  is a hardware or software component that stores data so that future requests for that data can be served faster.  A `cache hit` occurs when the requested data can be found in a cache, while a cache miss occurs when it cannot. Cache hits are served by reading data from the cache, which is faster than recomputing a result or reading from a slower data store; thus, the more requests that can be served from the cache, the faster the system performs.

<br>
<br>
<br>

# Operation

- Hardware implements cache as a block of memory for temporary storage of data likely to be used again. Central processing units (CPUs) and hard disk drives (HDDs) frequently use a cache, as do web browsers and web servers.
  
  A cache is made up of a pool of entries. Each entry has associated data, which is a copy of the same data in some backing store. Each entry also has a tag, which specifies the identity of the data in the backing store of which the entry is a copy.

- When the cache client (a CPU, web browser, operating system) needs to access data presumed to exist in the backing store, it first checks the cache. If an entry can be found with a tag matching that of the desired data, the data in the entry is used instead. This situation is known as a `cache hit`. For example, a web browser program might check its local cache on disk to see if it has a local copy of the contents of a web page at a particular URL. In this example, the URL is the tag, and the content of the web page is the data

- The alternative situation, when the cache is checked and found not to contain any entry with the desired tag, is known as a `cache miss`. This requires a more expensive access of data from the backing store. Once the requested data is retrieved, it is typically copied into the cache, ready for the next access. There are many algorithms used for `cache hit` and `cache miss` you can research them

<br>
<br>
<br>

# Writing Policies 

- When a system writes data to cache, it must at some point write that data to the backing store as well. The timing of this write is controlled by what is known as the write policy. There are two basic writing approaches:
  - Write-through: write is done synchronously both to the cache and to the backing store.
  - Write-back (also called write-behind): initially, writing is done only to the cache. The write to the backing store is postponed until the modified content is about to be replaced by another cache block.

  A write-back cache is more complex to implement, since it needs to track which of its locations have been written over, and mark them as dirty for later writing to the backing store.
  
<br>
<br>
<br>

# Hardware Caches

...

<br>
<br>
<br>

# Software Caches

...

<br>
<br>
<br>

# Web Cache

- A Web cache (or HTTP cache) is an information technology for the temporary storage (caching) of Web documents, such as Web pages, images, and other types of Web multimedia, to reduce server lag. A Web cache system stores copies of documents passing through it; subsequent requests may be satisfied from the cache if certain conditions are met

















